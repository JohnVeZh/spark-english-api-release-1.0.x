package cn.sparke.user.modules.v1.favorities.bean;

import cn.sparke.core.common.bean.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class FavoriteBookBean extends BaseEntity {
    private String name;
    private String productId;
    private String brief;
    private int saleNum;
    private String listImg;
    private int evaluateStar;

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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public String getListImg() {
        return listImg;
    }

    public void setListImg(String listImg) {
        this.listImg = listImg;
    }

    public int getEvaluateStar() {
        return evaluateStar;
    }

    public void setEvaluateStar(int evaluateStar) {
        this.evaluateStar = evaluateStar;
    }
}
