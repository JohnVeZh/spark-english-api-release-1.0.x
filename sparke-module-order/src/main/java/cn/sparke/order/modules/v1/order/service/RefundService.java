package cn.sparke.order.modules.v1.order.service;

import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.order.modules.v1.order.bean.RefundBean;
import cn.sparke.order.modules.v1.order.constants.OrderConstants;
import cn.sparke.order.modules.v1.order.entity.OrderDetailsCollection;
import cn.sparke.order.modules.v1.order.entity.OrderDetailsEntity;
import cn.sparke.order.modules.v1.order.mapper.OrderMapper;
import cn.sparke.order.modules.v1.order.mapper.RefundMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zhangbowen on 2017/7/13.
 */
@Service
@Transactional
public class RefundService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RefundMapper refundMapper;


    /**
     * 退货申请
     *
     * @param refundBean
     */
    public ResponseEntity refund(RefundBean refundBean) {
        String userId = ContextUtils.getCurAuth().getUserId();
        //根据订单详情id获取订单详情信息
        OrderDetailsEntity orderDetailsEntity = refundMapper.getOrderDetailByUser(userId, refundBean.getOrderDetailId());
        if (orderDetailsEntity == null) {
            return new ResponseErrorEntity(StatusCode.CANNOT_REFUND, HttpStatus.BAD_REQUEST);
        }
        //如果是网课退款
        if (orderDetailsEntity.getProductType() == OrderConstants.ORDER_TYPE_NETWORK) {
            //获取网课的视频总数
            int videoNum = refundMapper.findNetworkCourseVideoNum(orderDetailsEntity.getProductId());
            //获取当前用户看了多少门网课
            int playNum = refundMapper.findVideoAlreadyPlayNum(orderDetailsEntity.getProductId());
            //获取配套的列表
            List<OrderDetailsCollection> collectionList = refundMapper.findOrderDetailCollectionList(orderDetailsEntity.getId());
            //计算配套的价格
            BigDecimal collectionPrice = orderDetailsEntity.getProductPrice().subtract(collectionList.stream().map(OrderDetailsCollection::getProductPrice).reduce(new BigDecimal(0), BigDecimal::add));
            BigDecimal needRefundMoney = orderDetailsEntity.getDealPrice().subtract(collectionPrice).divide(new BigDecimal(videoNum), 10).multiply(new BigDecimal(playNum));
            refundBean.setMoney(needRefundMoney);
        } else {
            refundBean.setMoney(orderDetailsEntity.getDealPrice());
        }

        refundBean.setOrderId(orderDetailsEntity.getOrderId());
        refundBean.setOrderCode(orderDetailsEntity.getOrderCode());
        refundBean.setUserId(userId);
        refundBean.preInsert();
        refundMapper.insert(refundBean);

        //如果商品类型为网课，修改用户网课状态为不可用
        if (orderDetailsEntity.getProductType() == OrderConstants.ORDER_TYPE_NETWORK) {
            refundMapper.updateUserNetworkDisabled(orderDetailsEntity.getProductId());
        }
        //更新订单详情表的状态
        OrderDetailsEntity updateOrderDetail = new OrderDetailsEntity();
        updateOrderDetail.setId(orderDetailsEntity.getId());
        updateOrderDetail.setRefundStatus(OrderConstants.ORDER_DETAIL.REFUND_ING);
        updateOrderDetail.preUpdate();
        orderMapper.updateOrderDetail(updateOrderDetail);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    /**
     * 退款详情
     *
     * @param orderDetailId
     * @return
     */
    public RefundBean refundInfo(String orderDetailId) {
        return refundMapper.refundInfo(orderDetailId);
    }

}
