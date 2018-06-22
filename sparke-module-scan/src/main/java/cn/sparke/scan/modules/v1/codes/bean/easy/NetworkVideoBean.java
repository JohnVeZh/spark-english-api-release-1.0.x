package cn.sparke.scan.modules.v1.codes.bean.easy;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by john on 2017/7/10.
 * 简视频实体
 */
public class NetworkVideoBean extends BaseEntity {

    private Integer sectionCode; //学段code
    private String catalogId; //目录id
    private String name; //视频名称
    private String qrCode; //二维码
    private String ccId; //视频ccid
    private String img; //图片路径

    public Integer getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(Integer sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
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
