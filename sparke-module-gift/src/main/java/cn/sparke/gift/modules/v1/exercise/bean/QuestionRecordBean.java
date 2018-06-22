package cn.sparke.gift.modules.v1.exercise.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public class QuestionRecordBean extends BaseEntity {
    //用户id
    private String userId;
    //试卷id
    private String paperId;
    //学段
    private Integer sectionCode;
    //题目类型(1.听力 2.阅读 3.翻译 4.写作)
    private Integer questionType;
    //试卷结构
    private String structureId;
    //试题数目
    private Integer questionNum;
    //记录类型(1、专项2、配套专区)
    private int type;
    //题目名称
    private String questionName;
    //题目id
    private String questionId;
    //是否做完(0.否 1.是)
    private Integer isFinish;
    //用时
    private Integer useTime;
    //难易程度(0. 无 1.简单 2.中等 3.难)
    private Integer difficultyLevel;

    //拓展
    private QuestionReportBean reportInfo;


    private List<QuestionRecordDetailBean> recordDetailBeans;
    public void setUserId(String userId){
        this.userId=userId;
    }
    public String getUserId(){
        return this.userId;
    }
    public void setPaperId(String paperId){
        this.paperId=paperId;
    }
    public String getPaperId(){
        return this.paperId;
    }
    public void setSectionCode(Integer sectionCode){
        this.sectionCode=sectionCode;
    }
    public Integer getSectionCode(){
        return this.sectionCode;
    }
    public void setQuestionType(Integer questionType){
        this.questionType=questionType;
    }
    public Integer getQuestionType(){
        return this.questionType;
    }
    public void setStructureId(String structureId){
        this.structureId=structureId;
    }
    public String getStructureId(){
        return this.structureId;
    }
    public void setQuestionNum(Integer questionNum){
        this.questionNum=questionNum;
    }
    public Integer getQuestionNum(){
        return this.questionNum;
    }
    public void setQuestionId(String questionId){
        this.questionId=questionId;
    }
    public String getQuestionId(){
        return this.questionId;
    }
    public void setIsFinish(Integer isFinish){
        this.isFinish=isFinish;
    }
    public Integer getIsFinish(){
        return this.isFinish;
    }
    public void setDifficultyLevel(Integer difficultyLevel){
        this.difficultyLevel=difficultyLevel;
    }
    public Integer getDifficultyLevel(){
        return this.difficultyLevel;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public List<QuestionRecordDetailBean> getRecordDetailBeans() {
        return recordDetailBeans;
    }

    public void setRecordDetailBeans(List<QuestionRecordDetailBean> recordDetailBeans) {
        this.recordDetailBeans = recordDetailBeans;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public QuestionReportBean getReportInfo() {
        return reportInfo;
    }

    public void setReportInfo(QuestionReportBean reportInfo) {
        this.reportInfo = reportInfo;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }
}
