package cn.sparke.support.modules.v1.word.bean.vo;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 11:20
 */
public class Words {
    private String id;
    private String name;
    private String phonetic;
    private String pronunciationUrl;
    private String paraphrase;
    private String sentence;
    //1已存在错题本0不存在错题本
    private Integer isNew = 0;

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
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


}
