package cn.sparke.user.modules.v1.users.bean;

import cn.sparke.core.common.bean.BaseEntity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * Created by zhangbowen on 2017/1/2.
 */
public class UserRegBean extends BaseEntity {
    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "手机号格式不正确")
    private String phone;
    @NotBlank
    @Length(min = 32, max = 32, message = "密码格式不正确")
    private String password;
    @NotBlank
    @Pattern(regexp = "\\d{4}", message = "验证码格式不正确")
    private String code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
