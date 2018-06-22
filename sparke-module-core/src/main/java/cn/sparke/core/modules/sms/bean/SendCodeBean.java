package cn.sparke.core.modules.sms.bean;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by zhangbowen on 2016/5/17.
 */
public class SendCodeBean {
    @NotBlank
    @Pattern(regexp = "[0-9]{11}")
    private String phone;
    @NotNull
    @Range(min = 1, max = 5)
    private Integer type;
    private String code;

    public SendCodeBean(String phone, Integer type, String code) {
        this.phone = phone;
        this.type = type;
        this.code = code;
    }

    public SendCodeBean() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
