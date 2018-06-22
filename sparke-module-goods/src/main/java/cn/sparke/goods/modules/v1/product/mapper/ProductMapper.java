package cn.sparke.goods.modules.v1.product.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.goods.modules.v1.product.bean.ProductBean;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yangye on 2017/7/13.
 */
public interface ProductMapper extends BaseMapper<ProductBean> {

    ProductBean getProductNetworkCourseById(@Param("productId") String productId);

    ProductBean getProductBookById(@Param("productId") String productId, @Param("userId") String userId);

}
