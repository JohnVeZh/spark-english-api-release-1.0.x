package cn.sparke.gift.modules.v1.exercise.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by Administrator on 2017/7/13.
 */
public class QuestionOptionBean extends BaseEntity{
    //问题id
    private String itemId;
    //选项名称(A B C D)
    private String name;
    //选项内容
    private String content;
    //是否为正确答案(0.否 1.是)
    private Integer isAnswer;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setContent(String content){
        this.content=content;
    }
    public String getContent(){
        return this.content;
    }
    public void setIsAnswer(Integer isAnswer){
        this.isAnswer=isAnswer;
    }
    public Integer getIsAnswer(){
        return this.isAnswer;
    }
}
