package cn.sparke.easy.modules.v1.papers.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by wanghaiguang on 2017/7/28.
 */
public class OptionBean extends BaseEntity {

    private String name; //"选项名称", //A B C D
    private String content; //选项内容
    private Integer isAnswer; //"是否为答案"//0.否 1.是


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

    public Integer getIsAnswer() {
        return isAnswer;
    }

    public void setIsAnswer(Integer isAnswer) {
        this.isAnswer = isAnswer;
    }
}
