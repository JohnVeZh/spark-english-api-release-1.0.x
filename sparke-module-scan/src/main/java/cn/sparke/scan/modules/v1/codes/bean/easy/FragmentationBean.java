package cn.sparke.scan.modules.v1.codes.bean.easy;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by john on 2017/7/10.
 * 碎片和简写作实体
 */
public class FragmentationBean extends BaseEntity {

    private String qrCode; //二维码
    private String hearUrl; //听力路径
    private String name; //名称
    private Integer type; //类型(1.碎片 2.写作翻译)
    private Integer sectionCode; //学段(写作翻译时用到)
    private String catalogId; //目录id

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getHearUrl() {
        return hearUrl;
    }

    public void setHearUrl(String hearUrl) {
        this.hearUrl = hearUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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
}
