package cn.sparke.goods.modules.v1.book.bean;

import cn.sparke.core.common.bean.BaseEntity;
import java.util.List;

/**
 * @author yangye    2017/7/11
 */
public class ProductBookTypeBean extends BaseEntity{
    private String name;
    private String parentId;
    private List<ProductBookTypeBean> childList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<ProductBookTypeBean> getChildList() {
        return childList;
    }

    public void setChildList(List<ProductBookTypeBean> childList) {
        this.childList = childList;
    }
}
