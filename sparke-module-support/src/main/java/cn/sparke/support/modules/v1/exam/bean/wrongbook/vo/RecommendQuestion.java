package cn.sparke.support.modules.v1.exam.bean.wrongbook.vo;

import java.io.Serializable;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/14 13:22
 */
public class RecommendQuestion implements Serializable {
    private static final long serialVersionUID  = 2L;
    private String id;
    private String structureId;
    private String name;
    private int type;
    private double wrongRate;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStructureId() {
        return structureId;
    }

    public void setStructureId(String structureId) {
        this.structureId = structureId;
    }

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

    public double getWrongRate() {
        return wrongRate;
    }

    public void setWrongRate(double wrongRate) {
        this.wrongRate = wrongRate;
    }
}
