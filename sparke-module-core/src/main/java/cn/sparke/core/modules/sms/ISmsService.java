package cn.sparke.core.modules.sms;


import cn.sparke.core.modules.sms.bean.SendCodeBean;

/**
 * Created by lichq on 2016-09-01.
 */
public interface ISmsService {
    boolean sendSmsCode(SendCodeBean sendCodeBean);
}
