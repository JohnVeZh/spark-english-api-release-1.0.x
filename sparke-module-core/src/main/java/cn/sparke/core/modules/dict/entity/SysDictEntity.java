package cn.sparke.core.modules.dict.entity;

import cn.sparke.core.common.bean.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhangbowen on 2017/5/5.
 */
public class SysDictEntity extends BaseEntity{
    private String value;
    private String label;
    private String type;
    private String description;
    private String parentId;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
