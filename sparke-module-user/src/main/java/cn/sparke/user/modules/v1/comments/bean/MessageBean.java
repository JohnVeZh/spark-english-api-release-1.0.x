package cn.sparke.user.modules.v1.comments.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class MessageBean extends BaseEntity {
    private String title;
    private String content;
    private String intro;
    private Integer targetType;
    private String img;
    private String url;
    private Integer jumpType;
    private String contentId;
    private Integer pushStatus;
    private String userId;
    private int isRead;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getJumpType() {
        return jumpType;
    }

    public void setJumpType(Integer jumpType) {
        this.jumpType = jumpType;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public Integer getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(Integer pushStatus) {
        this.pushStatus = pushStatus;
    }
}
