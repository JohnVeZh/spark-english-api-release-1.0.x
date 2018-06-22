package cn.sparke.base.modules.v1.banners.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class BannerBean extends BaseEntity {
    private String title;
    private String img;
    private Integer jumpType;
    private String url;
    private String contentId;
    private Integer terminalType;
    private Integer moduleType;
    private Integer sectionCode;
    private String content;
    private List<CouponRuleBean> couponRuleList;

    public List<CouponRuleBean> getCouponRuleList() {
        return couponRuleList;
    }

    public void setCouponRuleList(List<CouponRuleBean> couponRuleList) {
        this.couponRuleList = couponRuleList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(Integer terminalType) {
        this.terminalType = terminalType;
    }

    public Integer getModuleType() {
        return moduleType;
    }

    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }

    public Integer getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(Integer sectionCode) {
        this.sectionCode = sectionCode;
    }

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

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }
}
