package cn.sparke.core.modules.captcha.bean;

public class CaptchaBean {
    private String captchaToken;
    private String data;

    public CaptchaBean() {
    }

    public String getCaptchaToken() {
        return captchaToken;
    }

    public void setCaptchaToken(String captchaToken) {
        this.captchaToken = captchaToken;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
