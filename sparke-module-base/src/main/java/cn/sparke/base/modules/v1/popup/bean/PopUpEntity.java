package cn.sparke.base.modules.v1.popup.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.Date;

public class PopUpEntity extends BaseEntity {

    private String title;

    private String img;

    private Byte jumpType;

    private String url;

    private Date startTime;

    private Date endTime;

    private Byte showModule;

    private Byte status;

    private Integer sort;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Byte getJumpType() {
        return jumpType;
    }

    public void setJumpType(Byte jumpType) {
        this.jumpType = jumpType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Byte getShowModule() {
        return showModule;
    }

    public void setShowModule(Byte showModule) {
        this.showModule = showModule;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


}