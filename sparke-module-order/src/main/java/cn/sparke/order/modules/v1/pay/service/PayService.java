package cn.sparke.order.modules.v1.pay.service;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.core.modules.token.constants.TokenConstants;
import cn.sparke.order.modules.v1.alipay.service.AliPayService;
import cn.sparke.order.modules.v1.order.constants.OrderConstants;
import cn.sparke.order.modules.v1.order.entity.OrderDetailsEntity;
import cn.sparke.order.modules.v1.order.entity.OrderEntity;
import cn.sparke.order.modules.v1.order.entity.UserNetworkEntity;
import cn.sparke.order.modules.v1.order.mapper.OrderMapper;
import cn.sparke.order.modules.v1.order.utils.OrderUtils;
import cn.sparke.order.modules.v1.pay.bean.AppAliSignBean;
import cn.sparke.order.modules.v1.pay.bean.CallBackBean;
import cn.sparke.order.modules.v1.weixinPay.service.WeiXinPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhangbowen on 2017/7/14.
 */
@Service
@Transactional
public class PayService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private WeiXinPayService weiXinPayService;
    @Autowired
    private AliPayService aliPayService;

    /**
     * 剔除已经拥有的网课
     *
     * @param orderDetailList
     * @return
     */
    private List<OrderDetailsEntity> clearAlreadyNetwork(String userId, List<OrderDetailsEntity> orderDetailList) {
        //获取所有的网课商品id
        List<OrderDetailsEntity> allNetworkList = orderDetailList.stream().filter(orderDetails -> orderDetails.getProductType() == OrderConstants.ORDER_TYPE_NETWORK)
                .collect(Collectors.toList());
        if (allNetworkList.size() == 0) {
            return allNetworkList;
        }
        //获取已经存在的网课id
        List<String> existNetworkProductIdList = orderMapper.existNetworkProductList(userId, allNetworkList);
        //过滤出不存在的网课返回
        return allNetworkList.stream().filter(orderDetailsEntity -> !existNetworkProductIdList.contains(orderDetailsEntity.getProductId())).collect(Collectors.toList());
    }

    /**
     * 根据类型和订单id获取支付参数
     *
     * @param orderId
     * @param type
     * @return
     */
    public ResponseEntity getSignStr(String orderId, Integer type) {
        OrderEntity queryOrder = new OrderEntity();
        queryOrder.setId(orderId);
        OrderEntity orderEntity = orderMapper.getOrderAndDetails(queryOrder);
        AuthEntity authEntity = ContextUtils.getCurAuth();
        String userId = authEntity.getUserId();
        int terminal = authEntity.getTerminal();
        if (orderEntity == null || orderEntity.getOrderStatus() != OrderConstants.STATUS.NOT_PAY || !orderEntity.getUserId().equals(userId)) {
            return new ResponseErrorEntity(StatusCode.ORDER_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        //剔除已经拥有的网课列表
        if (orderEntity.getType() == OrderConstants.ORDER_TYPE_NETWORK) {
            List<OrderDetailsEntity> orderDetailList = clearAlreadyNetwork(userId, orderEntity.getOrderDetailsList());
            if (orderDetailList == null || orderDetailList.size() == 0) {
                return new ResponseErrorEntity(StatusCode.ALREADY_BUY_NETWORK, HttpStatus.BAD_REQUEST);
            }
        }
        //更新订单的交易单号
        String orderTradeNo = OrderUtils.generateOrderCode();
        orderEntity.setOrderTradeNo(orderTradeNo);
        switch (terminal) {
            case TokenConstants.TERMINAL.ANDROID:
            case TokenConstants.TERMINAL.IOS:
                switch (type) {
                    case OrderConstants.PAY_TYPE.ALI_PAY:
                        return ResponseEntity.ok(new AppAliSignBean(aliPayService.appSign(orderEntity)));
                    case OrderConstants.PAY_TYPE.WEI_XIN:
                        return ResponseEntity.ok(weiXinPayService.appPay(orderEntity));
                }
                return new ResponseEntity(HttpStatus.OK);
            case TokenConstants.TERMINAL.M://wap支付只有支付宝
                return ResponseEntity.ok(aliPayService.mForm(orderEntity));
            case TokenConstants.TERMINAL.PC:
                switch (type) {
                    case OrderConstants.PAY_TYPE.ALI_PAY:
                        return ResponseEntity.ok(aliPayService.pcForm(orderEntity));
                    case OrderConstants.PAY_TYPE.WEI_XIN:
                        return ResponseEntity.ok(weiXinPayService.pcPay(orderEntity));
                }
                return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 支付成功回调
     *
     * @param callBackBean
     * @return
     */
    public boolean payCallBack(CallBackBean callBackBean) {
        //获取订单详情
        OrderEntity queryOrder = new OrderEntity();
        queryOrder.setId(callBackBean.getOrderId());
        OrderEntity orderEntity = orderMapper.getOrderAndDetails(queryOrder);
        if (orderEntity == null || orderEntity.getOrderStatus() != OrderConstants.STATUS.NOT_PAY) {
            return false;
        }
        if (orderEntity.getOrderPrice().compareTo(callBackBean.getPayPrice()) != 0) {
            return false;
        }
        List<String> networkIdList = null;
        //如果是网课订单，过滤掉已经存在的网课
        if (orderEntity.getType() == OrderConstants.ORDER_TYPE_NETWORK) {
            List<OrderDetailsEntity> orderDetailList = clearAlreadyNetwork(orderEntity.getUserId(), orderEntity.getOrderDetailsList());
            networkIdList = orderMapper.findNetworkIdList(orderDetailList.stream().map(OrderDetailsEntity::getProductId).collect(Collectors.toList()));
        }
        //组装需要更新订单的数据
        OrderEntity updateOrder = new OrderEntity();
        updateOrder.setId(orderEntity.getId());
        //更新订单状态
        if (orderEntity.getType() == OrderConstants.ORDER_TYPE_BOOK) {
            updateOrder.setOrderStatus(OrderConstants.STATUS.NOT_SEND);
        } else if (orderEntity.getType() == OrderConstants.ORDER_TYPE_NETWORK) {
            if (orderEntity.getIsSend() == OrderConstants.NEED_SEND) {
                //待发货
                updateOrder.setOrderStatus(OrderConstants.STATUS.NOT_SEND);
            } else {
                //已完成
                updateOrder.setOrderStatus(OrderConstants.STATUS.FINISH);
            }
        }
        updateOrder.setPayTime(new Date());
        updateOrder.setPayType(callBackBean.getPayType());
        updateOrder.setTradeNo(callBackBean.getTrade_no());
        updateOrder.setOrderTradeNo(callBackBean.getOrderTradeNo());
        updateOrder.setPayPrice(callBackBean.getPayPrice());
        updateOrder.preUpdate();
        orderMapper.update(updateOrder);
        //批量更新产品数量
        orderMapper.updateProductNum(orderEntity.getOrderDetailsList());
        String userId = orderEntity.getUserId();
        //如果是网课订单，插入到用户网课关系表
        if (networkIdList != null && networkIdList.size() != 0) {
            orderMapper.batchInsertUserNetwork(networkIdList.stream().map(networkId -> {
                UserNetworkEntity userNetworkEntity = new UserNetworkEntity();
                userNetworkEntity.setUserId(userId);
                userNetworkEntity.setNetworkCourseId(networkId);
                userNetworkEntity.setType(OrderConstants.USER_NETWORK.TYPE_ORDER);
                userNetworkEntity.preInsert();
                return userNetworkEntity;
            }).collect(Collectors.toList()));
        }
        return true;
    }
}
