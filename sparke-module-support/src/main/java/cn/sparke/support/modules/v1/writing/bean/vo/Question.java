package cn.sparke.support.modules.v1.writing.bean.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 19:20
 */
public class Question{
    private String id;
    private String content;
    private String analysis;
    private String reference;
    @JsonIgnore
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
