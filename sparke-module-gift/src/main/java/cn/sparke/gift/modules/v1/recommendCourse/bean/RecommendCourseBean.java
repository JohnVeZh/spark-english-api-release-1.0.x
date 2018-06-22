package cn.sparke.gift.modules.v1.recommendCourse.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * @author yangye    2017/7/12
 */
public class RecommendCourseBean extends BaseEntity{

    private String productId;
    private String name;
    private String listImg;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListImg() {
        return listImg;
    }

    public void setListImg(String listImg) {
        this.listImg = listImg;
    }

}
