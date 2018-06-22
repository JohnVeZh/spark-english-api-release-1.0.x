package cn.sparke.order.modules.v1.weixinPay.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by zhangbowen on 2016/7/26.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class WeiXinPayResultBean {
    private String return_code;
    private String return_msg;

    public WeiXinPayResultBean() {
    }

    public WeiXinPayResultBean(String return_code, String return_msg) {
        this.return_code = return_code;
        this.return_msg = return_msg;
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }
}
