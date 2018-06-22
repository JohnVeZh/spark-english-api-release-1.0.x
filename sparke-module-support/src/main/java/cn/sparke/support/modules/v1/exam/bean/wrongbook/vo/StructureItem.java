package cn.sparke.support.modules.v1.exam.bean.wrongbook.vo;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 21:36
 */
public class StructureItem {
    private String id;
    private String name;
    private Integer num;
    private Integer questionType;

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
