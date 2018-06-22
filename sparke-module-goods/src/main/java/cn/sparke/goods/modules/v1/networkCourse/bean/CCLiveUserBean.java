package cn.sparke.goods.modules.v1.networkCourse.bean;

/**
 * CC视频直播验证，响应用户实体
 * Created by Administrator on 2017-08-02.
 */
public class CCLiveUserBean {
    String id = ""; // 用户的唯一标示
    String name = "";   // 用户的名称，在聊天室中显示该名称
    String avatar = ""; // 用户的头像，在直播页面中显示该用户头像信息(长度不能超过400(包含)个字符，如果超过400个字符，登录会提示参数错误)
    CCMarquee marquee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public CCMarquee getMarquee() {
        return marquee;
    }

    public void setMarquee(CCMarquee marquee) {
        this.marquee = marquee;
    }
}
