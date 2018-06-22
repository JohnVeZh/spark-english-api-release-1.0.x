package cn.sparke.user.modules.v1.users.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * Created by zhangbowen on 2017/1/2.
 */
public class LoginUserBean {
    @NotBlank
    @Pattern(regexp = "\\d{11}",message = "手机号格式不正确")
    private String phone;
    @NotBlank
    @Length(min = 32, max = 32,message = "密码格式不正确")
    private String password;
    private String captchaToken;
    private String captchaCode;

    public String getCaptchaToken() {
        return captchaToken;
    }

    public void setCaptchaToken(String captchaToken) {
        this.captchaToken = captchaToken;
    }

    public String getCaptchaCode() {
        return captchaCode;
    }

    public void setCaptchaCode(String captchaCode) {
        this.captchaCode = captchaCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
