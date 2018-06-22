package cn.sparke.support.modules.v1.exam.bean.submit.po;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.Date;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/12 18:33
 */
public class TbQuestionReportDetail extends BaseEntity{

    /**
     * 试卷结构id(相当于长对话、新闻听力等)
     */
    private String structureId;

    /**
     * 结构名称
     */
    private String structureAlias;

    /**
     * 报告ID
     */
    private String reportId;

    /**
     * 总数量
     */
    private Integer totalNum = 0;

    /**
     * 作答数量
     */
    private Integer didNum = 0;

    /**
     * 未做数量
     */
    private Integer notDoneNum = 0;

    /**
     * 正确数量
     */
    private Integer rightNum = 0;

    /**
     * 错误数量
     */
    private Integer wrongNum = 0;

    /**
     * 正确率
     */
    private double rightRate;


    /**
     * 排序
     */
    private Integer sort;

    public String getStructureId() {
        return structureId;
    }

    public void setStructureId(String structureId) {
        this.structureId = structureId;
    }

    public String getStructureAlias() {
        return structureAlias;
    }

    public void setStructureAlias(String structureAlias) {
        this.structureAlias = structureAlias;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getDidNum() {
        return didNum;
    }

    public void setDidNum(Integer didNum) {
        this.didNum = didNum;
    }

    public Integer getNotDoneNum() {
        return notDoneNum;
    }

    public void setNotDoneNum(Integer notDoneNum) {
        this.notDoneNum = notDoneNum;
    }

    public Integer getRightNum() {
        return rightNum;
    }

    public void setRightNum(Integer rightNum) {
        this.rightNum = rightNum;
    }

    public Integer getWrongNum() {
        return wrongNum;
    }

    public void setWrongNum(Integer wrongNum) {
        this.wrongNum = wrongNum;
    }

    public double getRightRate() {
        return rightRate;
    }

    public void setRightRate(double rightRate) {
        this.rightRate = rightRate;
    }

    @Override
    public Integer getSort() {
        return sort;
    }

    @Override
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
