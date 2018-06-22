package cn.sparke.support.modules.v1.exam.bean.paper.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 15:11
 */
public class QuestionItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String structureId;
    @JsonIgnore
    private String pStructureIds;
    @JsonIgnore
    private int structureLevel;
    private String structureAlias;
    private String id;
    private String name;
    private String content;
    private int type;
    private String hasItem;
    private String questionNum;
    private String sectionCode;
    private String audioUrl;
    private Integer audioSize;
    private String tapescripts;
    private String translation;
    private String subtitleUrl;
    private Integer subtitleSize;
    private String reference;
    private String analysis;
    private String analysisCcId;
    private List<QuestionSubItem> questionItemList = new ArrayList<>();

    public Integer getAudioSize() {
        return audioSize;
    }

    public void setAudioSize(Integer audioSize) {
        this.audioSize = audioSize;
    }

    public Integer getSubtitleSize() {
        return subtitleSize;
    }

    public void setSubtitleSize(Integer subtitleSize) {
        this.subtitleSize = subtitleSize;
    }

    public int getStructureLevel() {
        return structureLevel;
    }

    public void setStructureLevel(int structureLevel) {
        this.structureLevel = structureLevel;
    }

    public String getpStructureIds() {
        return pStructureIds;
    }

    public void setpStructureIds(String pStructureIds) {
        this.pStructureIds = pStructureIds;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHasItem() {
        return hasItem;
    }

    public void setHasItem(String hasItem) {
        this.hasItem = hasItem;
    }

    public String getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(String questionNum) {
        this.questionNum = questionNum;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
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

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getSubtitleUrl() {
        return subtitleUrl;
    }

    public void setSubtitleUrl(String subtitleUrl) {
        this.subtitleUrl = subtitleUrl;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getAnalysisCcId() {
        return analysisCcId;
    }

    public void setAnalysisCcId(String analysisCcId) {
        this.analysisCcId = analysisCcId;
    }

    public List<QuestionSubItem> getQuestionItemList() {
        return questionItemList;
    }

    public void setQuestionItemList(List<QuestionSubItem> questionItemList) {
        this.questionItemList = questionItemList;
    }
}
