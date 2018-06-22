package cn.sparke.gift.modules.v1.exercise.bean;

import cn.sparke.core.common.bean.BaseEntity;
import cn.sparke.gift.modules.v1.exercise.common.ValidationGroup;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public class QuestionReportBean extends BaseEntity{
    //用户ID
    private String userId;
    //试卷id
    private String paperId;
    //试卷结构id(相当于长对话、新闻听力等)
    @NotNull(groups = { ValidationGroup.paperSubmit.class,ValidationGroup.quit.class,ValidationGroup.submit.class })
    private String paperStructureId;
    //题目id
    private String questionId;
    //报告类型
    private Integer catalogType;
    //试卷名称
    private String paperStructureAlias;
    //报告类型(1.试卷报告 2.试卷结构报告 3.题目报告)
    private Integer type;
    //学段
    private Integer sectionCode;
    //用时，单位秒
    @NotNull(groups = { ValidationGroup.paperSubmit.class })
    private Integer useTime;
    //总数量
    @NotNull(groups = { ValidationGroup.paperSubmit.class })
    private Integer totalNum;
    //作答数量
    @NotNull(groups = { ValidationGroup.paperSubmit.class })
    private Integer didNum;
    //未做数量
    @NotNull(groups = { ValidationGroup.paperSubmit.class })
    private Integer notDoneNum;
    //正确数量
    private Integer rightNum;
    //错误数量
    private Integer wrongNum;
    //正确率
    private BigDecimal rightRate;
    //题目列表
    private List<QuestionBean> questionList;

    //单个题目
    @NotNull(groups = { ValidationGroup.paperSubmit.class,ValidationGroup.quit.class,ValidationGroup.submit.class })
    private QuestionBean question;
    @NotNull(groups = { ValidationGroup.quit.class,ValidationGroup.submit.class })
    private Integer contentType;
    //小题列表
    private List<QuestionItemBean> questionItemList;
    //下一题内容
    private QuestionBean nextQuestion;

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
    public void setPaperStructureId(String paperStructureId){
        this.paperStructureId=paperStructureId;
    }
    public String getPaperStructureId(){
        return this.paperStructureId;
    }
    public void setPaperStructureAlias(String paperStructureAlias){
        this.paperStructureAlias=paperStructureAlias;
    }
    public String getPaperStructureAlias(){
        return this.paperStructureAlias;
    }
    public void setType(Integer type){
        this.type=type;
    }
    public Integer getType(){
        return this.type;
    }
    public void setSectionCode(Integer sectionCode){
        this.sectionCode=sectionCode;
    }
    public Integer getSectionCode(){
        return this.sectionCode;
    }
    public void setUseTime(Integer useTime){
        this.useTime=useTime;
    }
    public Integer getUseTime(){
        return this.useTime;
    }
    public void setTotalNum(Integer totalNum){
        this.totalNum=totalNum;
    }
    public Integer getTotalNum(){
        return this.totalNum;
    }
    public void setDidNum(Integer didNum){
        this.didNum=didNum;
    }
    public Integer getDidNum(){
        return this.didNum;
    }
    public void setNotDoneNum(Integer notDoneNum){
        this.notDoneNum=notDoneNum;
    }
    public Integer getNotDoneNum(){
        return this.notDoneNum;
    }
    public void setRightNum(Integer rightNum){
        this.rightNum=rightNum;
    }
    public Integer getRightNum(){
        return this.rightNum;
    }
    public void setWrongNum(Integer wrongNum){
        this.wrongNum=wrongNum;
    }
    public Integer getWrongNum(){
        return this.wrongNum;
    }
    public void setRightRate(BigDecimal rightRate){
        this.rightRate=rightRate;
    }
    public BigDecimal getRightRate(){
        return this.rightRate;
    }

    public List<QuestionBean> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionBean> questionList) {
        this.questionList = questionList;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public List<QuestionItemBean> getQuestionItemList() {
        return questionItemList;
    }

    public void setQuestionItemList(List<QuestionItemBean> questionItemList) {
        this.questionItemList = questionItemList;
    }


    public QuestionBean getQuestion() {
        return question;
    }

    public void setQuestion(QuestionBean question) {
        this.question = question;
    }



    public QuestionBean getNextQuestion() {
        return nextQuestion;
    }

    public void setNextQuestion(QuestionBean nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

    public Integer getCatalogType() {
        return catalogType;
    }

    public void setCatalogType(Integer catalogType) {
        this.catalogType = catalogType;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }
}
