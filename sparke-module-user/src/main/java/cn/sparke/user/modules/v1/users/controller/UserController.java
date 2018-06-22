package cn.sparke.user.modules.v1.users.controller;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.core.modules.captcha.constants.CaptchaConstants;
import cn.sparke.core.modules.captcha.service.CaptchaService;
import cn.sparke.core.modules.sms.SmsFacade;
import cn.sparke.core.modules.sms.bean.SendCodeBean;
import cn.sparke.core.modules.sms.constants.SmsConstants;
import cn.sparke.core.modules.token.constants.TokenConstants;
import cn.sparke.core.modules.token.service.TokenService;
import cn.sparke.user.modules.v1.users.bean.*;
import cn.sparke.user.modules.v1.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangbowen on 2017/7/10.
 */
@RestController
@RequestMapping("/${version}")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SmsFacade smsFacade;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private CaptchaService captchaService;

    /**
     * 登录
     *
     * @param loginBean
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity login(@Validated @RequestBody LoginUserBean loginBean) {
        int terminal = ContextUtils.getCurAuth().getTerminal();
        if (terminal == 0) {
            return new ResponseErrorEntity(StatusCode.VALIDATION_FAILED, HttpStatus.BAD_REQUEST);
        }
        //如果为PC验证验证码是否存在
        if (terminal == TokenConstants.TERMINAL.PC) {
            if (!captchaService.validCode(CaptchaConstants.TYPE_LOGIN, loginBean.getCaptchaCode(), loginBean.getCaptchaToken())) {
                return new ResponseErrorEntity(StatusCode.CAPTCHA_ERROR, HttpStatus.NOT_FOUND);
            }
        }
        return userService.login(loginBean);
    }

    /**
     * 注册
     *
     * @param regBean
     * @return
     */
    @PostMapping
    public ResponseEntity reg(@Validated @RequestBody UserRegBean regBean) {
        int terminal = ContextUtils.getCurAuth().getTerminal();
        if (terminal == 0) {
            return new ResponseErrorEntity(StatusCode.VALIDATION_FAILED, HttpStatus.BAD_REQUEST);
        }
        boolean success = smsFacade.validCode(new SendCodeBean(regBean.getPhone(), SmsConstants.TYPE.REG, regBean.getCode()));
        if (!success) {
            return new ResponseErrorEntity(StatusCode.VALIDATE_CODE_ERROR, HttpStatus.NOT_FOUND);
        }
        //如果为PC验证验证码是否存在
        if (terminal == TokenConstants.TERMINAL.PC) {
            if (!captchaService.validCode(CaptchaConstants.TYPE_REG, regBean.getCaptchaCode(), regBean.getCaptchaToken())) {
                return new ResponseErrorEntity(StatusCode.CAPTCHA_ERROR, HttpStatus.NOT_FOUND);
            }
        }
        return userService.reg(regBean);
    }

    /**
     * 忘记密码
     *
     * @param resetPwdBean
     * @return
     */
    @PutMapping("/password_reset")
    public ResponseEntity password_reset(@Validated @RequestBody ResetPwdBean resetPwdBean) {
        //判断验证码是否存在
        boolean existCode = smsFacade.validCode(new SendCodeBean(resetPwdBean.getPhone(), SmsConstants.TYPE.FORGET_PWD, resetPwdBean.getCode()));
        if (!existCode) {
            return new ResponseErrorEntity(StatusCode.VALIDATE_CODE_ERROR, HttpStatus.BAD_REQUEST);
        }
        return userService.password_reset(resetPwdBean);
    }

    /**
     * 修改密码
     *
     * @param changePwdBean
     * @return
     */
    @PutMapping("/password_modify")
    @LoginAnnot
    public ResponseEntity password_modify(@Validated @RequestBody ChangePwdBean changePwdBean) {
        return userService.password_modify(changePwdBean);
    }

    /**
     * 退出登录
     *
     * @return
     */
    @DeleteMapping("/logout")
    public ResponseEntity logout() {
        AuthEntity authEntity = ContextUtils.getCurAuth();
        tokenService.removeToken(authEntity.getTerminal(), authEntity.getUserId());
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     * 用户是否存在
     *
     * @return
     */
    @GetMapping
    public ResponseEntity exist(@RequestParam String phone) {
        if (userService.existPhone(phone)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    /**
     * 修改手机号
     *
     * @param changePhoneBean
     * @return
     */
    @PutMapping("/phone_modify")
    @LoginAnnot
    public ResponseEntity phone_modify(@Validated @RequestBody ChangePhoneBean changePhoneBean) {
        //验证短信验证码
        boolean existCode = smsFacade.validCode(new SendCodeBean(changePhoneBean.getOldPhone(), SmsConstants.TYPE.CHANGE_PHONE, changePhoneBean.getOldSmsCode()));
        if (!existCode) {
            return new ResponseErrorEntity(StatusCode.VALIDATE_CODE_ERROR, HttpStatus.BAD_REQUEST);
        }
        existCode = smsFacade.validCode(new SendCodeBean(changePhoneBean.getPhone(), SmsConstants.TYPE.CHANGE_PHONE, changePhoneBean.getSmsCode()));
        if (!existCode) {
            return new ResponseErrorEntity(StatusCode.VALIDATE_CODE_ERROR, HttpStatus.BAD_REQUEST);
        }

        return userService.phone_modify(changePhoneBean);
    }
}
