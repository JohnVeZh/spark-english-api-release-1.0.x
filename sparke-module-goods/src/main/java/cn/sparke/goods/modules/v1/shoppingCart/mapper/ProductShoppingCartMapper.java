package cn.sparke.goods.modules.v1.shoppingCart.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.goods.modules.v1.shoppingCart.bean.ProductShoppingCartBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yangye on 2017/7/12.
 */
public interface ProductShoppingCartMapper extends BaseMapper<ProductShoppingCartBean> {

    List<ProductShoppingCartBean> findList(@Param("userId") String userId);

    int getShoppingCartNum(@Param("userId") String userId);
}
