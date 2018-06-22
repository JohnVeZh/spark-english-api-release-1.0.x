package cn.sparke.goods.modules.v1.networkCourse.bean;

/**
 * Created by Administrator on 2017/7/26.
 */
public class CCVideoResponseBean {
    String version = "1";           // 返回文档版本，固定值1，必填
    int enable = 0;                 // 视频是否允许完整播放，必填，0: 不允许; 1: 允许
    int freetime = 0;           // 视频试看时间，必填
    String message = "请购买后重试！"; // 提示消息
    String callback = "";       // 不允许播放，或者试看结束时回调的页面js函数，访问函数时会携带vid参数，为空字符串时不回调
    CCMarquee marquee;          // 跑马灯节点信息，选填

    public CCVideoResponseBean() {
    }

    public CCVideoResponseBean(int enable, String message, String callback) {
        this.enable = enable;
        this.message = message;
        this.callback = callback;
    }

    public CCVideoResponseBean(int enable, String message) {
        this.enable = enable;
        this.message = message;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getFreetime() {
        return freetime;
    }

    public void setFreetime(int freetime) {
        this.freetime = freetime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public CCMarquee getMarquee() {
        return marquee;
    }

    public void setMarquee(CCMarquee marquee) {
        this.marquee = marquee;
    }
}
