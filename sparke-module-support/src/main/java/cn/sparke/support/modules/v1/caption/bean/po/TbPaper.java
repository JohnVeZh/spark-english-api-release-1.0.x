package cn.sparke.support.modules.v1.caption.bean.po;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 21:10
 */
public class TbPaper extends BaseEntity {

    /**
     * 目录id
     */
    private String catalogId;

    /**
     * 名称
     */
    private String name;

    /**
     * 内容类型（0.不区分1.听力2.阅读3.翻译4.写作;默认0）
     */
    private int contentType;

    /**
     * code
     */
    private String code;

    /**
     * 试卷图片
     */
   
    private String img;

    /**
     * 父id
     */
   
    private String parentId;

    /**
     * 级别
     */
   
    private int level;

    /**
     * 是否为叶子节点(0.否 1.是)
     */
   
    private int isLeaf;


    /**
     * 备注
     */
    private String remarks;

    /**
     * 排序
     */
   
    private Integer sort;


    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
    public String getRemarks() {
        return remarks;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public Integer getSort() {
        return sort;
    }

    @Override
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
