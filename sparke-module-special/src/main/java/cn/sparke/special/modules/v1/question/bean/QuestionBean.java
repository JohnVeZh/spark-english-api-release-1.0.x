package cn.sparke.special.modules.v1.question.bean;

import cn.sparke.core.common.bean.BaseEntity;
import cn.sparke.special.modules.v1.common.ValidationGroup;
import cn.sparke.special.modules.v1.record.bean.QuestionRecordBean;
import cn.sparke.special.modules.v1.record.bean.QuestionRecordDetailBean;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */
public class QuestionBean extends BaseEntity{
    @NotNull(groups = { ValidationGroup.paperSubmit.class ,ValidationGroup.quit.class,ValidationGroup.submit.class})
    private String id;
   private String name;//题目名称
   private String content;//	题干
    @NotNull(groups = { ValidationGroup.paperSubmit.class })
   private Integer type;//题目类型(1.听力 2.阅读 3.翻译 4.写作)
   private Integer hasItem;//是否存在小题(0.否 1.是)
    @NotNull(groups = { ValidationGroup.quit.class })
   private Integer questionNum;//题目数量
   private Integer sectionCode;//学段code
   private String analysis;//解析


    //部分共用字段
    //译文
    private String translation;
    //参考范文
    private String reference;
    //视频讲解ccid
    private String analysisCcId;

    //听力题
    private String listeningId;
    //音频地址
    private String audioUrl;
    //听力原文
    private String tapescripts;
    //字幕文件地址
    private String subtitleUrl;

    //阅读题
    private String readingId;

    //翻译题
    private String translationId;

    //写作题
    private String writingId;


    //额外拓展字段
    private String structureId;
    //错题数目
    private Integer num;

    @NotNull(groups = { ValidationGroup.paperSubmit.class,ValidationGroup.quit.class })
    private List<QuestionItemBean> questionItemList;
    private QuestionRecordDetailBean recordDetail;
    //该题是否已做完0.否 1.是
    private Integer isFinish;
    // 是否有做题历史：0否，1是
    private Integer hasHistory;
    private Integer useTime;
    @NotNull(groups = { ValidationGroup.submit.class })
    private Integer difficultyLevel;
    private Integer isCollect;
    //记录数据
    private QuestionRecordBean recordInfo;
    private Integer readingType;//（阅读题时存在） 阅读题型：1篇章词汇、2信息匹配、3篇章阅读
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getHasItem() {
        return hasItem;
    }

    public void setHasItem(Integer hasItem) {
        this.hasItem = hasItem;
    }

    public Integer getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
    }

    public Integer getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(Integer sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAnalysisCcId() {
        return analysisCcId;
    }

    public void setAnalysisCcId(String analysisCcId) {
        this.analysisCcId = analysisCcId;
    }

    public String getListeningId() {
        return listeningId;
    }

    public void setListeningId(String listeningId) {
        this.listeningId = listeningId;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getTapescripts() {
        return tapescripts;
    }

    public void setTapescripts(String tapescripts) {
        this.tapescripts = tapescripts;
    }

    public String getSubtitleUrl() {
        return subtitleUrl;
    }

    public void setSubtitleUrl(String subtitleUrl) {
        this.subtitleUrl = subtitleUrl;
    }

    public String getReadingId() {
        return readingId;
    }

    public void setReadingId(String readingId) {
        this.readingId = readingId;
    }

    public String getTranslationId() {
        return translationId;
    }

    public void setTranslationId(String translationId) {
        this.translationId = translationId;
    }

    public String getWritingId() {
        return writingId;
    }

    public void setWritingId(String writingId) {
        this.writingId = writingId;
    }

    public String getStructureId() {
        return structureId;
    }

    public void setStructureId(String structureId) {
        this.structureId = structureId;
    }

    public List<QuestionItemBean> getQuestionItemList() {
        return questionItemList;
    }

    public void setQuestionItemList(List<QuestionItemBean> questionItemList) {
        this.questionItemList = questionItemList;
    }

    public QuestionRecordDetailBean getRecordDetail() {
        return recordDetail;
    }

    public void setRecordDetail(QuestionRecordDetailBean recordDetail) {
        this.recordDetail = recordDetail;
    }

    public Integer getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }

    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(Integer difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Integer getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Integer isCollect) {
        this.isCollect = isCollect;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    public QuestionRecordBean getRecordInfo() {
        return recordInfo;
    }

    public void setRecordInfo(QuestionRecordBean recordInfo) {
        this.recordInfo = recordInfo;
    }

    public Integer getHasHistory() {
        return hasHistory;
    }

    public void setHasHistory(Integer hasHistory) {
        this.hasHistory = hasHistory;
    }

    public Integer getReadingType() {
        return readingType;
    }

    public void setReadingType(Integer readingType) {
        this.readingType = readingType;
    }
}
