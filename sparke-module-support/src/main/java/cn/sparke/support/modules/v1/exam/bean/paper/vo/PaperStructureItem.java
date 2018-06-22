package cn.sparke.support.modules.v1.exam.bean.paper.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 15:14
 */
public class PaperStructureItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String alias;
    private int type;
    private int isLeaf;
    private int level;
    private String parentId;

    @JsonIgnore
    private String parentIds;

    private String sort;

    private List<QuestionItem> questionList = new ArrayList<>();
    private List<PaperStructureItem> children = new ArrayList<>();

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(int isLeaf) {
        this.isLeaf = isLeaf;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<QuestionItem> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionItem> questionList) {
        this.questionList = questionList;
    }

    public List<PaperStructureItem> getChildren() {
        return children;
    }

    public void setChildren(List<PaperStructureItem> children) {
        this.children = children;
    }
}
