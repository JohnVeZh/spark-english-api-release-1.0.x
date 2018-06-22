package cn.sparke.base.modules.v1.fragment.bean;

import cn.sparke.core.common.bean.BaseEntity;

public class StartImg extends BaseEntity {
    //标题
    private String title;
    //图片
    private String img;
    //跳转类型：0.无 1.富文本 2.外部链接 3.活动 4. 资讯5.图书 6.网课
    private Integer jumpType;
    //外部链接地址
    private String url;
    //是否展示（0、隐藏1、展示）
    private Integer isShow;
    //内容id(资讯id、活动id、图书id、网课id)
    private String contentId;
    //内容
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
