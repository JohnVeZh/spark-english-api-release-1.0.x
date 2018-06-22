package cn.sparke.support.modules.v1.exam.bean.report.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/12 10:16
 */
public class ReportQuestionItem {

    //第一级结构名称
    @JsonIgnore
    private String structureId;
    private String tempId;
    private String name;
    private int totalNum;
    private int didNum;
    private int rightNum;
    private float rightRate;

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public int getRightNum() {
        return rightNum;
    }

    public void setRightNum(int rightNum) {
        this.rightNum = rightNum;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public String getStructureId() {
        return structureId;
    }

    public void setStructureId(String structureId) {
        this.structureId = structureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDidNum() {
        return didNum;
    }

    public void setDidNum(int didNum) {
        this.didNum = didNum;
    }

    public float getRightRate() {
        return rightRate;
    }

    public void setRightRate(float rightRate) {
        this.rightRate = formatDouble1(rightRate);
    }


    /**
     * 保留两位小数，四舍五入的一个老土的方法
     */
    private static float formatDouble1(double d) {
        return (float) Math.round(d * 100) / 100;
    }
}
