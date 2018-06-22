package cn.sparke.support.modules.v1.exam.bean.submit.po;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 20:26
 */
public class TbQuestionReport extends BaseEntity {

    private String userId;

    /**
     * 试卷id
     */
    private String paperId;

    /**
     * 试卷结构id(相当于长对话、新闻听力等)
     */
    private String paperStructureId;

    /**
     * 试卷结构id(相当于长对话、新闻听力等)
     */
    private String paperStructureAlias;

    /**
     * 报告类型(1.试卷报告 2.试卷结构报告 3.题目报告)
     */
    private int type;

    private int catalogType;

    /**
     * 学段
     */

    private int sectionCode;

    /**
     * 用时，单位秒
     */

    private Integer useTime;

    /**
     * 总数量
     */

    private Integer totalNum;

    /**
     * 作答数量
     */

    private Integer didNum;

    /**
     * 未做数量
     */

    private Integer notDoneNum;

    /**
     * 正确数量
     */

    private Integer rightNum;

    /**
     * 错误数量
     */

    private Integer wrongNum;

    /**
     * 正确率
     */

    private double rightRate;


    /**
     * 排序
     */

    private Integer sort;

    public int getCatalogType() {
        return catalogType;
    }

    public void setCatalogType(int catalogType) {
        this.catalogType = catalogType;
    }

    public String getPaperStructureAlias() {
        return paperStructureAlias;
    }

    public void setPaperStructureAlias(String paperStructureAlias) {
        this.paperStructureAlias = paperStructureAlias;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getPaperStructureId() {
        return paperStructureId;
    }

    public void setPaperStructureId(String paperStructureId) {
        this.paperStructureId = paperStructureId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(int sectionCode) {
        this.sectionCode = sectionCode;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
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
