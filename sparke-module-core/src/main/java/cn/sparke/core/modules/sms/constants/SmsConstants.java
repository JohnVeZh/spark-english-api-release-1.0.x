package cn.sparke.core.modules.sms.constants;

/**
 * Created by zhangbowen on 2017/7/8.
 */
public interface SmsConstants {
    interface TYPE {
        int REG = 1;//注册
        int FORGET_PWD = 2;//忘记密码
        int CHANGE_PWD = 3;//修改密码
        int BIND_PHONE = 4;//绑定手机号
        int CHANGE_PHONE = 5;//修改手机号

    }

    String CACHE_KEY = "-SMS-CODE-";//存储到缓存中的KEY
}
