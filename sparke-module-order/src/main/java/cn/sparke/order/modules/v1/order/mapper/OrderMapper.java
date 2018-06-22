package cn.sparke.order.modules.v1.order.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.order.modules.v1.order.bean.PostOrderProductBean;
import cn.sparke.order.modules.v1.order.bean.RefundBean;
import cn.sparke.order.modules.v1.order.entity.*;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public interface OrderMapper extends BaseMapper<OrderEntity> {

    /**
     * 根据提交的产品列表生成订单详情列表
     *
     * @param productList
     * @return
     */
    List<OrderDetailsEntity> generateOrderDetailList(@Param("list") List<PostOrderProductBean> productList);

    /**
     * 插入商品详情表
     *
     * @param insertDetailList
     * @return
     */
    int batchInsertDetails(@Param("list") List<OrderDetailsEntity> insertDetailList);

    /**
     * 插入商品详情搭配表
     *
     * @param orderDetailsCollectionsList
     * @return
     */
    int batchInsertDetailCollection(@Param("list") List<OrderDetailsCollection> orderDetailsCollectionsList);

    /**
     * 插入物流信息
     *
     * @param orderLogisticsEntity
     * @return
     */
    int insertLogistic(OrderLogisticsEntity orderLogisticsEntity);

    /**
     * 清除购物车
     *
     * @param shoppingCarIdList
     * @return
     */
    int clearShopping(@Param("list") List<String> shoppingCarIdList);

    /**
     * 获取用户已经购买的网课
     *
     * @param userId
     * @param allNetworkList
     * @return
     */
    List<String> existNetworkProductList(@Param("userId") String userId, @Param("list") List<OrderDetailsEntity> allNetworkList);

    /**
     * 根据兑换码生成订单详情数据
     *
     * @return
     */
    OrderDetailsEntity redeemProductByCode(String code);

    /**
     * 新增用户网课关系
     *
     * @param list
     */
    int batchInsertUserNetwork(List<UserNetworkEntity> list);

    /**
     * 根据用户获取订单
     *
     * @param userId
     * @param orderId
     * @return
     */
    OrderEntity getByUser(@Param("userId") String userId, @Param("orderId") String orderId);

    /**
     * 更新订单状态
     *
     * @param orderId
     * @param status
     */
    void updateOrderStatus(@Param("orderId") String orderId, @Param("status") int status);

    int updateCodeStatusUsed(@Param("code") String redeemCode, @Param("userId") String userId);


    /**
     * 更新订单详情表
     *
     * @param orderDetailsEntity
     */
    void updateOrderDetail(OrderDetailsEntity orderDetailsEntity);

    /**
     * 获取订单和订单详情数据
     *
     * @param queryOrder
     * @return
     */
    OrderEntity getOrderAndDetails(OrderEntity queryOrder);

    /**
     * 更新商品的购买数量
     *
     * @param orderDetailsList
     */
    int updateProductNum(List<OrderDetailsEntity> orderDetailsList);

    /**
     * 根据商品id列表获取网课id列表
     *
     * @param list
     * @return
     */
    List<String> findNetworkIdList(List<String> list);

    /**
     * 订单状态查询
     *
     * @param orderId
     * @return
     */
    OrderEntity orderStatus(String orderId);

}
