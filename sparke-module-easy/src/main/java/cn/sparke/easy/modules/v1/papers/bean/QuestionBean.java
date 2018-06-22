package cn.sparke.easy.modules.v1.papers.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.List;

/**
 * Created by wanghaiguang on 2017/7/28.
 */
public class QuestionBean extends BaseEntity {

    private String name; //题目名称
    private Integer type; //题目类型
    private String content; //题干
    private Integer hasItem; //是否存在小题
    private Integer questionNum; //题目数量
    private String analysis; //解析
    private String tapescripts; //听力原文
    private String audioUrl; //音频地址
    private String translation; //译文

    private List<ItemBean> questionItem;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getTapescripts() {
        return tapescripts;
    }

    public void setTapescripts(String tapescripts) {
        this.tapescripts = tapescripts;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public List<ItemBean> getQuestionItem() {
        return questionItem;
    }

    public void setQuestionItem(List<ItemBean> questionItem) {
        this.questionItem = questionItem;
    }
}
