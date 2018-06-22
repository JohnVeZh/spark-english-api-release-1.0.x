package cn.sparke.user.modules.v1.users.bean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class ChangePhoneBean {
    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "手机号格式不正确")
    private String oldPhone;
    @NotBlank
    @Pattern(regexp = "\\d{4}", message = "验证码格式不正确")
    private String oldSmsCode;
    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "手机号格式不正确")
    private String phone;
    @NotBlank
    @Pattern(regexp = "\\d{4}", message = "验证码格式不正确")
    private String smsCode;

    public String getOldPhone() {
        return oldPhone;
    }

    public void setOldPhone(String oldPhone) {
        this.oldPhone = oldPhone;
    }

    public String getOldSmsCode() {
        return oldSmsCode;
    }

    public void setOldSmsCode(String oldSmsCode) {
        this.oldSmsCode = oldSmsCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
