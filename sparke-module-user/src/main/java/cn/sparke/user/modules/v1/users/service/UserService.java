package cn.sparke.user.modules.v1.users.service;

import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.core.common.utils.Utils;
import cn.sparke.core.modules.cache.CacheFacade;
import cn.sparke.core.modules.captcha.constants.CaptchaConstants;
import cn.sparke.core.modules.dict.utils.DictUtils;
import cn.sparke.core.modules.sms.SmsFacade;
import cn.sparke.core.modules.sms.constants.SmsConstants;
import cn.sparke.core.modules.token.service.TokenService;
import cn.sparke.user.modules.v1.users.bean.*;
import cn.sparke.user.modules.v1.users.constants.UserConstants;
import cn.sparke.user.modules.v1.users.entity.UserEntity;
import cn.sparke.user.modules.v1.users.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * Created by zhangbowen on 2017/7/10.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private SmsFacade smsFacade;


    /**
     * 登录
     *
     * @param loginUserBean
     * @return
     */
    public ResponseEntity login(LoginUserBean loginUserBean) {
        //判断是否存在该用户
        UserEntity queryUser = new UserEntity();
        queryUser.setPhone(loginUserBean.getPhone());
        UserEntity existUser = userMapper.get(queryUser);
        //判断是否已经注册
        if (existUser == null) {
            return new ResponseErrorEntity(StatusCode.USER_NOT_REG, HttpStatus.BAD_REQUEST);
        }
        //是否已经被禁用
        if (existUser.getUserStatus() == UserConstants.STATUS.DISABLED) {
            return new ResponseErrorEntity(StatusCode.USER_DISABLED, HttpStatus.BAD_REQUEST);
        }
        //密码是否匹配
        if (!loginUserBean.getPassword().equalsIgnoreCase(existUser.getPassword())) {
            return new ResponseErrorEntity(StatusCode.PASSWORD_ERROR, HttpStatus.BAD_REQUEST);
        }
        //更新用户的登录时间
        UserEntity updateUser = new UserEntity();
        updateUser.setId(existUser.getId());
        updateUser.setLastLoginDate(new Date());
        updateUser.preUpdate();
        userMapper.update(updateUser);
        //生成token
        LoginSuccessBean successBean = new LoginSuccessBean();
        successBean.setId(existUser.getId());
        successBean.setToken(tokenService.handleToken(ContextUtils.getCurAuth().getTerminal(), existUser.getId()));
        if (!StringUtils.isEmpty(loginUserBean.getCaptchaToken())) {
            CacheFacade.delete(loginUserBean.getCaptchaToken() + CaptchaConstants.CAPTCHA_KEY + CaptchaConstants.TYPE_LOGIN);
        }
        return ResponseEntity.ok(successBean);
    }

    /**
     * 判断手机号是否存在
     *
     * @param phone
     * @return
     */
    public boolean existPhone(String phone) {
        //获得当前手机号是否已经注册
        UserEntity queryUser = new UserEntity();
        queryUser.setPhone(phone);
        UserEntity userEntity = userMapper.get(queryUser);
        //不为空，说明已经注册
        return userEntity != null;
    }

    /**
     * 注册
     *
     * @param regBean
     * @return
     */
    public ResponseEntity reg(UserRegBean regBean) {
        //判断是否已经注册
        if (existPhone(regBean.getPhone())) {
            return new ResponseErrorEntity(StatusCode.PHONE_EXIST, HttpStatus.BAD_REQUEST);
        }
        UserEntity insertUser = new UserEntity();
        insertUser.setPhone(regBean.getPhone());
        insertUser.setPassword(regBean.getPassword().toLowerCase());
        insertUser.setNickname(Utils.generateNameByPhone(regBean.getPhone()));
        insertUser.setHeaderImg(DictUtils.getDictValue(UserConstants.DICT.DEFAULT_HEADER_IMG, UserConstants.DICT.DEFAULT_HEADER_IMG, ""));
        insertUser.setSectionCode(UserConstants.SECTION.LEVEL_ONE);
        insertUser.setRegType(ContextUtils.getCurAuth().getTerminal());
        insertUser.preInsert();
        userMapper.insert(insertUser);
        smsFacade.removeCode(regBean.getPhone(), SmsConstants.TYPE.REG);
        if (!StringUtils.isEmpty(regBean.getCaptchaToken())) {
            CacheFacade.delete(regBean.getCaptchaToken() + CaptchaConstants.CAPTCHA_KEY + CaptchaConstants.TYPE_REG);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 重置密码
     *
     * @param resetPwdBean
     * @return
     */
    public ResponseEntity password_reset(ResetPwdBean resetPwdBean) {
        //判断手机号是否存在
        UserEntity queryUser = new UserEntity();
        queryUser.setPhone(resetPwdBean.getPhone());
        UserEntity existUser = userMapper.get(queryUser);
        if (existUser == null) {
            return new ResponseErrorEntity(StatusCode.USER_NOT_EXIST, HttpStatus.BAD_REQUEST);
        }
        //修改密码
        UserEntity updateUser = new UserEntity();
        updateUser.setId(existUser.getId());
        updateUser.setPassword(resetPwdBean.getPassword());
        updateUser.preUpdate();
        userMapper.update(updateUser);
        smsFacade.removeCode(resetPwdBean.getPhone(), SmsConstants.TYPE.FORGET_PWD);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 修改密码
     *
     * @param changePwdBean
     * @return
     */
    public ResponseEntity password_modify(ChangePwdBean changePwdBean) {
        //判断之前密码是否正确
        UserEntity queryUser = new UserEntity();
        queryUser.setId(ContextUtils.getCurAuth().getUserId());
        UserEntity existUser = userMapper.get(queryUser);
        if (existUser == null) {
            return new ResponseErrorEntity(StatusCode.USER_NOT_EXIST, HttpStatus.BAD_REQUEST);
        }
        //旧密码是否正确
        if (!changePwdBean.getOldPwd().equalsIgnoreCase(existUser.getPassword())) {
            return new ResponseErrorEntity(StatusCode.PASSWORD_ERROR, HttpStatus.BAD_REQUEST);
        }
        //修改新密码
        //修改密码
        UserEntity updateUser = new UserEntity();
        updateUser.setId(existUser.getId());
        updateUser.setPassword(changePwdBean.getPassword());
        updateUser.preUpdate();
        userMapper.update(updateUser);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 修改手机号
     *
     * @param changePhoneBean
     * @return
     */
    public ResponseEntity phone_modify(ChangePhoneBean changePhoneBean) {
        //判断新手机号是否已经注册
        if (existPhone(changePhoneBean.getPhone())) {
            return new ResponseErrorEntity(StatusCode.PHONE_EXIST, HttpStatus.BAD_REQUEST);
        }
        //更新手机号
        UserEntity userEntity = new UserEntity();
        userEntity.setId(ContextUtils.getCurAuth().getUserId());
        userEntity.setPhone(changePhoneBean.getPhone());
        userEntity.preUpdate();
        userMapper.update(userEntity);
        smsFacade.removeCode(changePhoneBean.getOldPhone(), SmsConstants.TYPE.CHANGE_PHONE);
        smsFacade.removeCode(changePhoneBean.getPhone(), SmsConstants.TYPE.CHANGE_PHONE);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
