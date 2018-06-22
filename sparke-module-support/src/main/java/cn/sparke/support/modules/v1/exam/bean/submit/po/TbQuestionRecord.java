package cn.sparke.support.modules.v1.exam.bean.submit.po;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 20:21
 */
public class TbQuestionRecord extends BaseEntity {

    private int type;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 试卷id
     */
    private String paperId;

    /**
     * 学段
     */
    private int sectionCode;

    /**
     * 题目类型(1.听力 2.阅读 3.翻译 4.写作)
     */
    private int questionType;

    private String structureId;

    private Integer questionNum;
    /**
     * 题目id
     */
    private String questionId;

    /**
     * 是否做完(0.否 1.是)
     */
    private int isFinish;

    /**
     * 难易程度(0. 无 1.简单 2.中等 3.难)
     */
    private int difficultyLevel;

    /**
     * 排序
     */
    private Integer sort;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public int getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(int sectionCode) {
        this.sectionCode = sectionCode;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public String getStructureId() {
        return structureId;
    }

    public void setStructureId(String structureId) {
        this.structureId = structureId;
    }

    public Integer getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public int getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(int isFinish) {
        this.isFinish = isFinish;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
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
