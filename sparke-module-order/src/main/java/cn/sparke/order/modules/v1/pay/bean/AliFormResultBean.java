package cn.sparke.order.modules.v1.pay.bean;

public class AliFormResultBean {
    private String formStr;

    public AliFormResultBean() {
    }

    public AliFormResultBean(String formStr) {
        this.formStr = formStr;
    }

    public String getFormStr() {
        return formStr;
    }

    public void setFormStr(String formStr) {
        this.formStr = formStr;
    }
}
