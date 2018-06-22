package cn.sparke.special.modules.v1.word.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */
public class WordBean extends BaseEntity{
    private String catalogId;//目录id
    private String name;//单词名称
    private String phonetic;//音标
    private String pronunciationUrl;//	发音文件地址
    private String paraphrase;//	释义
    private String sentence;//例句
    private String reference;//	例句翻译
    private String referenceAudioUrl;//	例句发音
    private List<WordQuestionOptionBean> options;//选项列表
    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public String getPronunciationUrl() {
        return pronunciationUrl;
    }

    public void setPronunciationUrl(String pronunciationUrl) {
        this.pronunciationUrl = pronunciationUrl;
    }

    public String getParaphrase() {
        return paraphrase;
    }

    public void setParaphrase(String paraphrase) {
        this.paraphrase = paraphrase;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferenceAudioUrl() {
        return referenceAudioUrl;
    }

    public void setReferenceAudioUrl(String referenceAudioUrl) {
        this.referenceAudioUrl = referenceAudioUrl;
    }

    public List<WordQuestionOptionBean> getOptions() {
        return options;
    }

    public void setOptions(List<WordQuestionOptionBean> options) {
        this.options = options;
    }
}
