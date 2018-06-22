package cn.sparke.easy.modules.v1.videos.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by wanghaiguang on 2017/7/11.
 * 简视频实体类
 */

public class VideoBean extends BaseEntity{

    private String name; //视频名称
    private String ccId; //视频ccid
    private String img; //图片路径

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCcId() {
        return ccId;
    }

    public void setCcId(String ccId) {
        this.ccId = ccId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
