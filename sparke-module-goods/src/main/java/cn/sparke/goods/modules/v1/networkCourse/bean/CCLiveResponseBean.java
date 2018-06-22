package cn.sparke.goods.modules.v1.networkCourse.bean;

/**
 * cc视频直播校验时响应实体
 * Created by Administrator on 2017-08-02.
 */
public class CCLiveResponseBean {

    String result = ""; // 验证结果，除“ok”外，云平台将其他结果均认为验证失败，即不允许登陆
    String message = ""; // 当用户不能登陆（验证结果不为“ok”）时，展示给登陆用户的提示信息。
    CCLiveUserBean user; //

    public CCLiveResponseBean(String result, String message, CCLiveUserBean user) {
        this.result = result;
        this.message = message;
        this.user = user;
    }

    public CCLiveResponseBean(String result, String message) {
        this.result = result;
        this.message = message;
    }

    public CCLiveResponseBean(String message) {
        this.message = message;
    }

    public CCLiveResponseBean(){}

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CCLiveUserBean getUser() {
        return user;
    }

    public void setUser(CCLiveUserBean user) {
        this.user = user;
    }
}
