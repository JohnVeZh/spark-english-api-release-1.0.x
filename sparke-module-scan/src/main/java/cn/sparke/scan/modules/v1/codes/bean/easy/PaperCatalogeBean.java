package cn.sparke.scan.modules.v1.codes.bean.easy;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by john on 2017/7/10.
 * 考场原音实体
 */
public class PaperCatalogeBean extends BaseEntity {

    private String name; //目录名称
    private Integer type; //类型(1.全真考场 2.字幕听力 3.简系列 4.专项练习)
    private Integer sectionCode; //学段code
    private String qrCode; //二维码
    private String parentId; //父id
    private Integer level;//级别

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

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
