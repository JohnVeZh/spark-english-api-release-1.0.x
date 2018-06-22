package cn.sparke.support.modules.v1.exam.bean.submit.vo.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 19:56
 */
public class SubmitQuestionItem {
    private String id;
    /**
     * 是否做完(0.否 1.是)
     */

    @NotNull(message = "请提交是否做完")
    private Integer isFinish;

    @NotBlank(message = "请提交结构ID")
    private String structureId;
    @NotBlank(message = "请提交结构ID")
    private String structureAlias;
    @Valid
    @NotNull(message = "请提交小题信息")
    @Size(min = 1,message = "请提交小题信息")
    private List<SubmitQuestionSubItem> questionItemList;

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

    public Integer getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SubmitQuestionSubItem> getQuestionItemList() {
        return questionItemList;
    }

    public void setQuestionItemList(List<SubmitQuestionSubItem> questionItemList) {
        this.questionItemList = questionItemList;
    }
}
