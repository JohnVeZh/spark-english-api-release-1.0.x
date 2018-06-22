package cn.sparke.support.modules.v1.exam.bean.report.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/12 10:18
 */
public class ReportStructure {

    //第一级结构名称
    @JsonIgnore
    private String structureId;
    private String name;
    private List<ReportQuestionItem> children;

    public String getStructureId() {
        return structureId;
    }

    public void setStructureId(String structureId) {
        this.structureId = structureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ReportQuestionItem> getChildren() {
        return children;
    }

    public void setChildren(List<ReportQuestionItem> children) {
        this.children = children;
    }
}
