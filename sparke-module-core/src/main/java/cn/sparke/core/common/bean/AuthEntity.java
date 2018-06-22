package cn.sparke.core.common.bean;

/**
 * Created by zhangbowen on 2017/5/4.
 */
public class AuthEntity {
    //请求用户
    private String userId;
    //请求token
    private String token;
    //请求设备类型（1.android 2.iOS 3.M站 4.PC 5.知米）
    private int terminal;
    //请求版本code
    private int versionCode;
    //ip
    private String ip;
    //uri
    private String uri;
    //学段
    private int sectionCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTerminal() {
        return terminal;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(int sectionCode) {
        this.sectionCode = sectionCode;
    }
}
