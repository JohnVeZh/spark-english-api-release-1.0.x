package cn.sparke.core.modules.sms.service.local;

import cn.sparke.core.modules.sms.ISmsService;
import cn.sparke.core.modules.sms.bean.SendCodeBean;

/**
 * Created by zhangbowen on 2017/5/5.
 */
public class LocalSmsService implements ISmsService {

    @Override
    public boolean sendSmsCode(SendCodeBean sendCodeBean) {
        return true;
    }
}
