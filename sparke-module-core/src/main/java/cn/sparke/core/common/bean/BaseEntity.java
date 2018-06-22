package cn.sparke.core.common.bean;

import cn.sparke.core.common.utils.Utils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.pagehelper.PageHelper;

import java.util.Date;

/**
 * Created by zhangbowen on 2017/5/4.
 */
@JsonIgnoreProperties(value = {"rows", "sortBy", "delFlag", "start", "openPager"})
public abstract class BaseEntity {
    private String id;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    //创建人
    private String createBy;
    //修改人
    private String updateBy;
    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    //删除标识(0:未删除1：删除)
    private String delFlag = "0";
    //分页开始
    private Integer start;
    private String remarks;
    private String query;
    private String orderBy;
    private Integer sort;
    private Integer rows = 10;

    public void setStart(Integer start) {
        this.start = start;
        PageHelper.offsetPage(start, rows);
    }

    public void setStart(Integer start, Integer rows) {
        this.start = start;
        PageHelper.offsetPage(start, rows);
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert() {
        this.id = Utils.uuid();
        this.updateDate = new Date();
        this.createDate = new Date();
    }

    public void preUpdate() {
        this.updateDate = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getStart() {
        return start;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
