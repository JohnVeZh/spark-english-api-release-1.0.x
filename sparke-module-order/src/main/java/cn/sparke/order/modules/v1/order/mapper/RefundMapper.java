package cn.sparke.order.modules.v1.order.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.order.modules.v1.order.bean.RefundBean;
import cn.sparke.order.modules.v1.order.entity.OrderDetailsCollection;
import cn.sparke.order.modules.v1.order.entity.OrderDetailsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/13.
 */
public interface RefundMapper extends BaseMapper<RefundBean> {


    /**
     * 根据用户获取订单详情
     *
     * @param userId
     * @param orderDetailId
     * @return
     */
    OrderDetailsEntity getOrderDetailByUser(@Param("userId") String userId, @Param("orderDetailId") String orderDetailId);

    /**
     * 网课设为失效
     *
     * @param productId
     */
    void updateUserNetworkDisabled(String productId);

    RefundBean refundInfo(String orderDetailId);

    List<OrderDetailsCollection> findOrderDetailCollectionList(String orderDetailId);

    /**
     * 获取网课已经播放的数量
     *
     * @param productId
     * @return
     */
    int findVideoAlreadyPlayNum(String productId);

    /**
     * 获取网课的视频总数
     *
     * @param productId
     * @return
     */
    int findNetworkCourseVideoNum(String productId);

}
