package cn.sparke.easy.modules.v1.papers.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by john on 2017/7/10.
 * 试卷实体
 */
public class PaperBean extends BaseEntity {

    private String catalogId; //目录id
    private String name; //名称
    private Integer contentType; //内容类型（0.不区分1.听力2.阅读3.翻译4.写作;默认0）
    private String code; //code
    private String img; //试卷图片
    private String parentId; //父id
    private Integer level; //级别
    private Integer isLeaf; //是否为叶子节点(0.否 1.是)

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

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }
}
