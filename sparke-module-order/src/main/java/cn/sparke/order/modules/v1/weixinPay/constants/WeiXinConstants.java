package cn.sparke.order.modules.v1.weixinPay.constants;

/**
 * Created by zhangbowen on 2017/7/14.
 */
public interface WeiXinConstants {
    int TYPE_APP = 1;
    int TYPE_PC = 2;

    enum SignType {
        MD5, HMACSHA256
    }

    String FAIL = "FAIL";
    String SUCCESS = "SUCCESS";
    String HMACSHA256 = "HMAC-SHA256";
    String MD5 = "MD5";

    String FIELD_SIGN = "sign";
    String FIELD_SIGN_TYPE = "sign_type";
}
