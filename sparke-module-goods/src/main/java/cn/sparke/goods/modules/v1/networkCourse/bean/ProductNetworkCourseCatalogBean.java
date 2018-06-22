package cn.sparke.goods.modules.v1.networkCourse.bean;

import cn.sparke.core.common.bean.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yangye    2017/7/12
 */
public class ProductNetworkCourseCatalogBean extends BaseEntity{

    private String name;
    private String networkCourseId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetworkCourseId() {
        return networkCourseId;
    }

    public void setNetworkCourseId(String networkCourseId) {
        this.networkCourseId = networkCourseId;
    }
}
