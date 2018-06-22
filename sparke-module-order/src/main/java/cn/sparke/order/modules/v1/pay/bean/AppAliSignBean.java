package cn.sparke.order.modules.v1.pay.bean;

/**
 * Created by zhangbowen on 2017/7/14.
 */
public class AppAliSignBean {
    private String sign;

    public AppAliSignBean() {
    }

    public AppAliSignBean(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
