package cn.sparke.core.modules.sms;

import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.ProjectProperties;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.Utils;
import cn.sparke.core.modules.cache.CacheFacade;
import cn.sparke.core.modules.sms.bean.CacheSmsCodeBean;
import cn.sparke.core.modules.sms.bean.SendCodeBean;
import cn.sparke.core.modules.sms.constants.SmsConstants;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by zhangbowen on 2016/1/4.
 */
@Service
public class SmsFacade {
    @Autowired
    private ISmsService smsService;
    @Autowired
    private ProjectProperties projectProperties;


    /**
     * 删除验证码
     *
     * @param phone
     * @param type
     * @return
     */
    public void removeCode(String phone, int type) {
        // 校验验证码
        CacheFacade.delete(phone + SmsConstants.CACHE_KEY + type);
    }

    /**
     * 验证验证码
     *
     * @param sendCodeBean
     * @return
     */
    public boolean validCode(SendCodeBean sendCodeBean) {
        //为开发模式
        if ("none".equals(projectProperties.sms)) {
            return true;
        }
        String phone = sendCodeBean.getPhone();
        Integer type = sendCodeBean.getType();
        // 校验验证码
        CacheSmsCodeBean cacheSmsCodeBean = CacheFacade.getObject(phone + SmsConstants.CACHE_KEY + type, new TypeReference<CacheSmsCodeBean>() {
        });
        if (cacheSmsCodeBean == null) {
            return false;
        }
        // 校验失败
        return cacheSmsCodeBean.getCode().equalsIgnoreCase(sendCodeBean.getCode());
    }

    /**
     * 发送验证码
     *
     * @param sendCodeBean
     */
    public ResponseEntity sendSmsCode(SendCodeBean sendCodeBean) {
        if ("none".equals(projectProperties.sms)) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        Integer type = sendCodeBean.getType();
        String phone = sendCodeBean.getPhone();
        // 校验验证码
        CacheSmsCodeBean existCode = CacheFacade.getObject(phone + SmsConstants.CACHE_KEY + type, new TypeReference<CacheSmsCodeBean>() {
        });
        //如果存在验证码，判断当前时间-发送时间>=发送间隔时间 不发送，存在发送
        if (existCode == null || System.currentTimeMillis() - existCode.getSendTime() >= existCode.getInterval() * 1000) {
            String validCode = Utils.generateSmsCode();
            sendCodeBean.setCode(validCode);
            boolean sendSuccess = false;
            if (smsService.sendSmsCode(sendCodeBean)) {
                sendSuccess = true;
            }
            if (sendSuccess) {
                CacheSmsCodeBean cacheSmsCodeBean = new CacheSmsCodeBean();
                cacheSmsCodeBean.setInterval(Utils.MINUTE);
                cacheSmsCodeBean.setSendTime(System.currentTimeMillis());
                cacheSmsCodeBean.setCode(validCode);
                CacheFacade.set(phone + SmsConstants.CACHE_KEY + type, cacheSmsCodeBean, Utils.MINUTE * 30);
                return new ResponseEntity(HttpStatus.CREATED);
            } else {
                return new ResponseErrorEntity(StatusCode.SEND_SMS_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
