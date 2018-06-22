package cn.sparke.support.modules.v1.exam.bean.paper.vo;

import java.io.Serializable;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 15:08
 */
public class OptionItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String content;
    private String isAnswer;

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

    public String getIsAnswer() {
        return isAnswer;
    }

    public void setIsAnswer(String isAnswer) {
        this.isAnswer = isAnswer;
    }
}
