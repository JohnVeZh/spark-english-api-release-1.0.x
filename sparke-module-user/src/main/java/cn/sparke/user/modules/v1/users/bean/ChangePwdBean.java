package cn.sparke.user.modules.v1.users.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class ChangePwdBean {
    @NotBlank
    @Length(min = 32, max = 32, message = "密码格式不正确")
    private String oldPwd;
    @NotBlank
    @Length(min = 32, max = 32, message = "密码格式不正确")
    private String password;

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
