package cn.sparke.support.modules.v1.exam.bean.submit.po;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.Date;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/13 13:26
 */
public class TbPaperStructure extends BaseEntity {

    /**
     * 试卷id
     */
    private String paperId;

    /**
     * 名称(part 1 section one)
     */
    private String name;

    /**
     * 别名(写作 阅读 section one)
     */
    private String alias;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 父id
     */
    private String parentIds;

    /**
     * 级别
     */
    private int level;

    /**
     * 是否叶子叶点(1.否 1.是)(叶子节点才会存在题目)
     */
    private int isLeaf;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 备注
     */
    private String remarks;

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(int isLeaf) {
        this.isLeaf = isLeaf;
    }

    @Override
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public Date getUpdateDate() {
        return updateDate;
    }

    @Override
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String getUpdateBy() {
        return updateBy;
    }

    @Override
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String getRemarks() {
        return remarks;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


}
