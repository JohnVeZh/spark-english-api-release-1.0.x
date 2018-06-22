package cn.sparke.user.modules.v1.users.bean;

/**
 * Created by zhangbowen on 2017/1/2.
 */
public class LoginSuccessBean {
    private String id;
    private String token;
    private int bindStatus;

    public int getBindStatus() {
        return bindStatus;
    }

    public void setBindStatus(int bindStatus) {
        this.bindStatus = bindStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
