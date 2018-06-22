package cn.sparke.order.modules.v1.order.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.order.modules.v1.order.entity.EvaluateEntity;
import cn.sparke.order.modules.v1.order.entity.OrderDetailsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/14.
 */
public interface EvaluateMapper extends BaseMapper<EvaluateEntity> {
    List<Integer> findScoreByProduct(String productId);

    void updateProductScore(@Param("productId") String productId, @Param("productScore") int productScore);

    /**
     * 根据用户获取订单详情
     *
     * @param userId
     * @param orderDetailId
     * @return
     */
    OrderDetailsEntity getOrderDetailByUser(@Param("userId") String userId, @Param("orderDetailId") String orderDetailId);

    List<String> findNotCommentList(String orderId);
}
