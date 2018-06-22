package cn.sparke.order.modules.v1.order.service;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.order.modules.v1.order.bean.*;
import cn.sparke.order.modules.v1.order.constants.OrderConstants;
import cn.sparke.order.modules.v1.order.entity.OrderDetailsCollection;
import cn.sparke.order.modules.v1.order.entity.OrderDetailsEntity;
import cn.sparke.order.modules.v1.order.entity.OrderEntity;
import cn.sparke.order.modules.v1.order.entity.UserNetworkEntity;
import cn.sparke.order.modules.v1.order.mapper.AddressMapper;
import cn.sparke.order.modules.v1.order.mapper.CouponMapper;
import cn.sparke.order.modules.v1.order.mapper.OrderMapper;
import cn.sparke.order.modules.v1.order.utils.OrderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zhangbowen on 2017/7/12.
 */
@Service
@Transactional
public class OrderService {
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private AddressMapper addressMapper;

    //===========================提交订单开始====================================

    /**
     * 提交订单
     *
     * @param postOrderBean
     * @return
     */
    public ResponseEntity postOrder(PostOrderBean postOrderBean) {
        List<PostOrderProductBean> postProductList = postOrderBean.getProductList();
        AuthEntity authEntity = ContextUtils.getCurAuth();
        String userId = authEntity.getUserId();
        String couponId = postOrderBean.getCouponId();
        CouponBean existCoupon = null;
        //判断是否存在优惠券
        if (!StringUtils.isEmpty(couponId)) {
            //判断优惠券id是否可用
            CouponBean queryCoupon = new CouponBean();
            queryCoupon.setUserId(userId);
            queryCoupon.setId(couponId);
            existCoupon = couponMapper.get(queryCoupon);
            if (existCoupon == null) {
                return new ResponseErrorEntity(StatusCode.COUPON_EXPIRED, HttpStatus.BAD_REQUEST);
            }
            //判断当前购买的商品中是否可用该优惠券
            String canUseProductId = existCoupon.getProductId();
            if (postProductList.stream().filter(p -> p.getProductId().equals(canUseProductId)).collect(Collectors.toList()).size() == 0) {
                return new ResponseErrorEntity(StatusCode.CAN_NOT_USE_COUPON, HttpStatus.BAD_REQUEST);
            }
        }
        //获取要删除的购物车列表
        List<String> shoppingCarIdList = postProductList.stream().filter(postOrderProductBean -> !StringUtils.isEmpty(postOrderProductBean.getShoppingCarId())).map(PostOrderProductBean::getShoppingCarId).collect(Collectors.toList());
        //获取订单详情列表
        List<OrderDetailsEntity> orderDetailList = orderMapper.generateOrderDetailList(postProductList);
        if (orderDetailList.size() == 0) {
            return new ResponseErrorEntity(StatusCode.GOODS_INFO_ERROR, HttpStatus.BAD_REQUEST);
        }
        //剔除已经拥有的网课列表
        if (postOrderBean.getType() == OrderConstants.ORDER_TYPE_NETWORK) {
            orderDetailList = clearAlreadyNetwork(userId, orderDetailList);
            if (orderDetailList == null || orderDetailList.size() == 0) {
                return new ResponseErrorEntity(StatusCode.ALREADY_BUY_NETWORK, HttpStatus.BAD_REQUEST);
            }
        }
        //填充购买数量
        orderDetailList = fillPayNum(orderDetailList, postProductList);
        //判断是否需要邮寄
        int needSend = needSend(orderDetailList);
        BigDecimal postagePrice = new BigDecimal(0);
        AddressBean addressBean = null;
        if (needSend == OrderConstants.NEED_SEND) {
            if (StringUtils.isEmpty(postOrderBean.getAddressId())) {
                return new ResponseErrorEntity(StatusCode.ADDRESS_ERROR, HttpStatus.BAD_REQUEST);
            }
            addressBean = addressMapper.getById(postOrderBean.getAddressId());
            if (addressBean == null) {
                return new ResponseErrorEntity(StatusCode.ADDRESS_ERROR, HttpStatus.BAD_REQUEST);
            }
            //获取邮费
            postagePrice = calculatePostage(orderDetailList);
        }
        //获取商品总金额
        BigDecimal totalProductPrice = calculateTotalProductPrice(orderDetailList);
        //如果存在优惠券，判断优惠券是否可以使用
        if (existCoupon != null) {
            if (totalProductPrice.compareTo(existCoupon.getMinMoney()) < 0) {
                return new ResponseErrorEntity(StatusCode.GOODS_LESS_THAN_COUPON, HttpStatus.BAD_REQUEST);
            }
        }
        //获取优惠券金额
        BigDecimal discountPrice = new BigDecimal(0);
        if (existCoupon != null) {
            discountPrice = existCoupon.getDiscountMoney();
        }
        //获取订单金额
        BigDecimal orderPrice = totalProductPrice.add(postagePrice).subtract(discountPrice);
        //获取商品总数
        int productNum = calculateProductNum(orderDetailList);

        if (orderPrice.doubleValue() <= 0 || totalProductPrice.doubleValue() <= 0) {
            return new ResponseErrorEntity(StatusCode.ORDER_PRICE_ERROR, HttpStatus.BAD_GATEWAY);
        }
        //组装订单数据
        OrderEntity insertOrder = new OrderEntity();
        insertOrder.setUserId(userId);
        insertOrder.setCouponId(couponId);
        insertOrder.setRemarks(postOrderBean.getRemarks());
        insertOrder.setType(postOrderBean.getType());
        insertOrder.setOrderCode(OrderUtils.generateOrderCode());
        insertOrder.setOrderPrice(orderPrice);
        insertOrder.setTotalProductPrice(totalProductPrice);
        insertOrder.setDiscountPrice(discountPrice);
        insertOrder.setPostagePrice(postagePrice);
        insertOrder.setProductNum(productNum);
        insertOrder.setFromType(authEntity.getTerminal());
        insertOrder.setOrderStatus(OrderConstants.STATUS.NOT_PAY);
        insertOrder.setPayType(OrderConstants.PAY_TYPE.NONE);
        insertOrder.setIsSend(needSend);
        insertOrder.setCouponId(couponId);
        insertOrder.preInsert();

        //组装订单详情表数据以及套餐数据
        List<OrderDetailsEntity> insertDetailList = generateInsertDetailList(insertOrder, orderDetailList);
        List<OrderDetailsCollection> orderDetailsCollectionsList = insertDetailList.stream().flatMap(orderDetailsEntity -> orderDetailsEntity.getOrderDetailsCollectionList().stream()).collect(Collectors.toList());
        List<Supplier> taskList = new ArrayList<>();
        //插入订单
        taskList.add(() -> orderMapper.insert(insertOrder));
        //插入订单详情数据
        taskList.add(() -> orderMapper.batchInsertDetails(insertDetailList));
        //插入订单搭配数据
        if (orderDetailsCollectionsList.size() > 0) {
            taskList.add(() -> orderMapper.batchInsertDetailCollection(orderDetailsCollectionsList));
        }
        //如果收货地址不为空，插入收货地址
        if (addressBean != null) {
            AddressBean finalAddressBean = addressBean;
            taskList.add(() -> orderMapper.insertLogistic(finalAddressBean.convertLogistic(insertOrder.getId())));
        }
        //如果优惠券不为空，更新优惠券使用状态
        if (existCoupon != null) {
            CouponBean updateCoupon = new CouponBean();
            updateCoupon.setId(existCoupon.getId());
            updateCoupon.setStatus(OrderConstants.COUPON.TAKE_UP);
            updateCoupon.preUpdate();
            taskList.add(() -> couponMapper.update(updateCoupon));
        }
        //删除购物车
        if (shoppingCarIdList != null && shoppingCarIdList.size() > 0) {
            taskList.add(() -> orderMapper.clearShopping(shoppingCarIdList));
        }
        taskList.forEach(Supplier::get);
        OrderEntity resultOrder = new OrderEntity();
        resultOrder.setId(insertOrder.getId());
        return new ResponseEntity<>(resultOrder, HttpStatus.CREATED);
    }

    /**
     * 填充商品的购买数量
     *
     * @param orderDetailList
     * @return
     */
    private List<OrderDetailsEntity> fillPayNum(List<OrderDetailsEntity> orderDetailList, List<PostOrderProductBean> postProductList) {
        return orderDetailList.stream().map(orderDetails -> {
            String productId = orderDetails.getProductId();
            Optional<Integer> numOp = postProductList.stream().filter(postProduct -> postProduct.getProductId().equals(productId)).map(PostOrderProductBean::getProductNum).findFirst();
            numOp.ifPresent(orderDetails::setNum);
            //重置网课的数量为1
            if (orderDetails.getProductType() == OrderConstants.ORDER_TYPE_NETWORK) {
                orderDetails.setNum(1);
            }
            orderDetails.getOrderDetailsCollectionList().forEach(collection -> {
                collection.setNum(orderDetails.getNum());
            });
            return orderDetails;
        }).filter(orderDetails -> orderDetails.getNum() != null).collect(Collectors.toList());
    }

    /**
     * 生成要插入的商品详情信息以及商品详情搭配信息
     *
     * @param insertOrder
     * @param orderDetailList
     * @return
     */
    private List<OrderDetailsEntity> generateInsertDetailList(OrderEntity insertOrder, List<OrderDetailsEntity> orderDetailList) {
        String orderId = insertOrder.getId();
        //计算优惠的折扣率
        BigDecimal discountRate = insertOrder.getOrderPrice().subtract(insertOrder.getPostagePrice()).divide(insertOrder.getTotalProductPrice(), 10, BigDecimal.ROUND_FLOOR);
        List<OrderDetailsEntity> list = orderDetailList.stream().map(detail -> {
            detail.setOrderId(orderId);
            detail.setDealPrice(discountRate.multiply(detail.getProductPrice()).multiply(new BigDecimal(detail.getNum())).setScale(2, BigDecimal.ROUND_FLOOR));
            detail.setDiscountPrice(detail.getProductPrice().multiply(new BigDecimal(detail.getNum())).subtract(detail.getDealPrice()).setScale(2, BigDecimal.ROUND_FLOOR));
            detail.preInsert();
            detail.getOrderDetailsCollectionList().forEach(collection -> {
                collection.setOrderDetailId(detail.getId());
                collection.preInsert();
            });
            return detail;
        }).sorted(Comparator.comparing(OrderDetailsEntity::getDiscountPrice)).collect(Collectors.toList());
        //补差
        BigDecimal notEnoughPrice = list.stream().map(OrderDetailsEntity::getDealPrice).reduce(BigDecimal::add).get();
        BigDecimal needPatchPrice = insertOrder.getOrderPrice().subtract(insertOrder.getPostagePrice()).subtract(notEnoughPrice);
        OrderDetailsEntity detailsEntity = list.get(list.size() - 1);
        detailsEntity.setDealPrice(detailsEntity.getDealPrice().add(needPatchPrice));
        detailsEntity.setDiscountPrice(detailsEntity.getDiscountPrice().subtract(needPatchPrice));
        return list;
    }

    /**
     * 计算邮费
     *
     * @param orderDetailList
     * @return
     */
    private BigDecimal calculatePostage(List<OrderDetailsEntity> orderDetailList) {
        return orderDetailList.stream().filter(orderDetailsEntity -> orderDetailsEntity.getIsSend() == OrderConstants.NEED_SEND)
                .filter(orderDetailsEntity -> orderDetailsEntity.getIsPostage() == OrderConstants.UN_IS_POSTAGE)
                .map(OrderDetailsEntity::getPostage)
                .reduce(new BigDecimal(0), BigDecimal::add);
    }

    /**
     * 是否需要邮寄
     *
     * @param orderDetailList
     * @return
     */
    private int needSend(List<OrderDetailsEntity> orderDetailList) {
        return orderDetailList.stream().filter(orderDetailsEntity -> orderDetailsEntity.getIsSend() == OrderConstants.NEED_SEND).count() > 0 ? OrderConstants.NEED_SEND : OrderConstants.UN_NEED_SEND;
    }

    /**
     * 计算商品总数
     *
     * @return
     */
    private int calculateProductNum(List<OrderDetailsEntity> orderDetailList) {
        return orderDetailList.stream().map(OrderDetailsEntity::getNum).reduce(0, (num1, num2) -> num1 + num2);
    }

    /**
     * 计算商品总价
     *
     * @return
     */
    private BigDecimal calculateTotalProductPrice(List<OrderDetailsEntity> orderDetailList) {
        return orderDetailList.stream().map(product -> product.getProductPrice().multiply(new BigDecimal(product.getNum()))).reduce(new BigDecimal(0), BigDecimal::add);
    }

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
    //===========================提交订单结束====================================

    /**
     * 确认订单
     *
     * @param postOrderBean
     * @return
     */
    public ResponseEntity confirmOrder(PostOrderBean postOrderBean) {
        String userId = ContextUtils.getCurAuth().getUserId();
        List<PostOrderProductBean> postProductList = postOrderBean.getProductList();
        //获取订单详情列表
        List<OrderDetailsEntity> orderDetailList = orderMapper.generateOrderDetailList(postProductList);
        if (orderDetailList.size() == 0) {
            return new ResponseErrorEntity(StatusCode.GOODS_INFO_ERROR, HttpStatus.BAD_REQUEST);
        }
        //剔除已经拥有的网课列表
        if (postOrderBean.getType() == OrderConstants.ORDER_TYPE_NETWORK) {
            orderDetailList = clearAlreadyNetwork(userId, orderDetailList);
            if (orderDetailList == null || orderDetailList.size() == 0) {
                return new ResponseErrorEntity(StatusCode.ALREADY_BUY_NETWORK, HttpStatus.BAD_REQUEST);
            }
        }
        //填充购买数量
        orderDetailList = fillPayNum(orderDetailList, postProductList);
        //获取商品总金额
        BigDecimal totalProductPrice = calculateTotalProductPrice(orderDetailList);
        //获取是否需要邮寄
        int needSend = needSend(orderDetailList);
        BigDecimal postagePrice = null;
        AddressBean defaultAddress = null;
        int isPostage = OrderConstants.UN_IS_POSTAGE;
        if (needSend == OrderConstants.NEED_SEND) {
            //获取邮费
            postagePrice = calculatePostage(orderDetailList);
            //获取是否包邮
            if (postagePrice.compareTo(new BigDecimal(0)) == 0) {
                isPostage = OrderConstants.IS_POSTAGE;
            }
            //获取默认收货地址
            defaultAddress = addressMapper.getUserDefaultAddress(userId);
        }
        //获取商品总数
        int productNum = calculateProductNum(orderDetailList);
        //获取可用优惠券列表
        CouponBean queryCoupon = new CouponBean();
        queryCoupon.setMinMoney(totalProductPrice);
        queryCoupon.setUserId(userId);
        queryCoupon.setProductIdList(orderDetailList.stream().map(OrderDetailsEntity::getProductId).collect(Collectors.toList()));
        List<CouponBean> couponList = couponMapper.findListByProduct(queryCoupon);

        //组装确认订单数据
        ConfirmOrderBean confirmOrderBean = new ConfirmOrderBean();
        confirmOrderBean.setTotalProductPrice(totalProductPrice);
        confirmOrderBean.setPostage(postagePrice);
        confirmOrderBean.setIsSend(needSend);
        confirmOrderBean.setIsPostage(isPostage);
        confirmOrderBean.setProductNum(productNum);
        confirmOrderBean.setDefaultAddress(defaultAddress);
        confirmOrderBean.setProductList(orderDetailList);
        confirmOrderBean.setCouponList(couponList);
        return ResponseEntity.ok(confirmOrderBean);
    }

    /**
     * 兑换码兑换网课
     *
     * @param redeemBean
     * @return
     */
    public ResponseEntity redeemNetwork(RedeemBean redeemBean) {
        String redeemCode = redeemBean.getRedeemCode();
        AuthEntity authEntity = ContextUtils.getCurAuth();
        String userId = authEntity.getUserId();
        //根据兑换码获取兑换码详情
        OrderDetailsEntity orderDetailsEntity = orderMapper.redeemProductByCode(redeemCode);
        if (orderDetailsEntity == null) {
            return new ResponseErrorEntity(StatusCode.REDEEM_EXPIRED, HttpStatus.BAD_REQUEST);
        }
        //剔除已经拥有的网课列表
        List<OrderDetailsEntity> orderDetailList = new ArrayList<>();
        orderDetailList.add(orderDetailsEntity);
        orderDetailList = clearAlreadyNetwork(userId, orderDetailList);
        if (orderDetailList == null || orderDetailList.size() == 0) {
            return new ResponseErrorEntity(StatusCode.ALREADY_BUY_NETWORK, HttpStatus.BAD_REQUEST);
        }
        List<Supplier> taskList = new ArrayList<>();
        AddressBean addressBean = null;
        //如果需要邮寄，则判断地址是否正确
        if (orderDetailsEntity.getIsSend() == OrderConstants.NEED_SEND) {
            if (StringUtils.isEmpty(redeemBean.getAddressId())) {
                return new ResponseErrorEntity(StatusCode.ADDRESS_ERROR, HttpStatus.BAD_REQUEST);
            }
            addressBean = addressMapper.getById(redeemBean.getAddressId());
            if (addressBean == null) {
                return new ResponseErrorEntity(StatusCode.ADDRESS_ERROR, HttpStatus.BAD_REQUEST);
            }
        }
        //拼装订单数据
        OrderEntity insertOrder = new OrderEntity();
        insertOrder.setUserId(userId);
        insertOrder.setType(OrderConstants.ORDER_TYPE_NETWORK);
        insertOrder.setOrderCode(OrderUtils.generateOrderCode());
        insertOrder.setOrderPrice(new BigDecimal(0));
        insertOrder.setTotalProductPrice(orderDetailsEntity.getProductPrice());
        insertOrder.setProductNum(1);
        insertOrder.setDiscountPrice(new BigDecimal(0));
        insertOrder.setPostagePrice(new BigDecimal(0));
        insertOrder.setIsSend(orderDetailsEntity.getIsSend());
        insertOrder.setFromType(authEntity.getTerminal());
        insertOrder.setPayType(OrderConstants.PAY_TYPE.REDEEM_CODE);
        insertOrder.setPayPrice(new BigDecimal(0));
        insertOrder.setPayTime(new Date());
        insertOrder.setRemarks(redeemBean.getRemarks());
        insertOrder.setRedeemId(orderDetailsEntity.getRedeemId());
        if (insertOrder.getIsSend() == OrderConstants.NEED_SEND) {
            insertOrder.setOrderStatus(OrderConstants.STATUS.NOT_SEND);
        } else {
            insertOrder.setOrderStatus(OrderConstants.STATUS.FINISH);
        }
        insertOrder.preInsert();

        //拼装订单详情数据
        orderDetailsEntity.setNum(1);
        orderDetailsEntity.setOrderId(insertOrder.getId());
        orderDetailsEntity.setDealPrice(new BigDecimal(0));
        orderDetailsEntity.setDiscountPrice(new BigDecimal(0));
        orderDetailsEntity.preInsert();
        //插入订单表
        taskList.add(() -> orderMapper.insert(insertOrder));
        //插入订单详情表
        List<OrderDetailsEntity> batchInsertDetails = new ArrayList<>();
        batchInsertDetails.add(orderDetailsEntity);
        taskList.add(() -> orderMapper.batchInsertDetails(batchInsertDetails));
        //插入用户网课关系表
        UserNetworkEntity userNetworkEntity = new UserNetworkEntity();
        userNetworkEntity.setUserId(userId);
        userNetworkEntity.setNetworkCourseId(orderDetailsEntity.getNetworkCourseId());
        userNetworkEntity.setType(OrderConstants.USER_NETWORK.TYPE_REDEEM);
        userNetworkEntity.preInsert();
        List<UserNetworkEntity> userNetworkList = new ArrayList<>();
        userNetworkList.add(userNetworkEntity);
        taskList.add(() -> orderMapper.batchInsertUserNetwork(userNetworkList));
        //更新兑换码状态为已使用
        taskList.add(() -> orderMapper.updateCodeStatusUsed(redeemCode, userId));
        //更新商品的购买数量
        List<OrderDetailsEntity> orderDetailsList = new ArrayList<>();
        orderDetailsList.add(orderDetailsEntity);
        taskList.add(() -> orderMapper.updateProductNum(orderDetailsList));
        //如果收货地址不为空，插入收货地址
        if (addressBean != null) {
            AddressBean finalAddressBean = addressBean;
            taskList.add(() -> orderMapper.insertLogistic(finalAddressBean.convertLogistic(insertOrder.getId())));
        }
        taskList.forEach(Supplier::get);
        return new ResponseErrorEntity(HttpStatus.CREATED);
    }

    /**
     * 订单详情
     *
     * @param orderEntity
     * @return
     */
    public OrderEntity info(OrderEntity orderEntity) {
        return orderMapper.get(orderEntity);
    }


    /**
     * 取消订单
     *
     * @param orderId
     */
    public void cancel(String orderId) {
        String userId = ContextUtils.getCurAuth().getUserId();
        //根据订单获取订单详情
        OrderEntity orderEntity = orderMapper.getByUser(userId, orderId);
        if (orderEntity == null) {
            return;
        }
        String couponId = orderEntity.getCouponId();
        //如果优惠券不为空
        if (!StringUtils.isEmpty(couponId)) {
            //更新优惠券状态
            CouponBean updateCoupon = new CouponBean();
            updateCoupon.setId(couponId);
            updateCoupon.setStatus(OrderConstants.COUPON.NORMAL);
            updateCoupon.preUpdate();
            couponMapper.update(updateCoupon);
        }
        //更新订单状态为已取消
        orderMapper.updateOrderStatus(orderId, OrderConstants.STATUS.CANCEL);
    }

    /**
     * 确认收货
     *
     * @param orderId
     */
    public void cargo_confirm(String orderId) {
        String userId = ContextUtils.getCurAuth().getUserId();
        //根据订单获取订单详情
        OrderEntity orderEntity = orderMapper.getByUser(userId, orderId);
        if (orderEntity == null) {
            return;
        }
        //如果为网课，修改为已完成，如果为商品，修改为待评价
        if (orderEntity.getType() == OrderConstants.ORDER_TYPE_NETWORK) {
            //更新订单状态为已完成
            orderMapper.updateOrderStatus(orderId, OrderConstants.STATUS.FINISH);
        } else {
            //更新订单状态为已完成
            orderMapper.updateOrderStatus(orderId, OrderConstants.STATUS.NOT_COMMENT);
        }

    }

    /**
     * 删除订单
     *
     * @param orderId
     */
    public ResponseEntity deleteOrder(String orderId) {
        String userId = ContextUtils.getCurAuth().getUserId();
        //根据订单获取订单详情
        OrderEntity orderEntity = orderMapper.getByUser(userId, orderId);
        if (orderEntity == null) {
            return new ResponseErrorEntity(StatusCode.ORDER_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        //当用户订单状态为 待发货、待收货时，无法删除订单
        if (orderEntity.getOrderStatus() == OrderConstants.STATUS.NOT_SEND || orderEntity.getOrderStatus() == OrderConstants.STATUS.SEND) {
            return new ResponseErrorEntity(StatusCode.ORDER_CAN_NOT_DELETE, HttpStatus.BAD_REQUEST);
        }
        orderMapper.delete(orderId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     * 订单状态查询
     *
     * @param orderId
     * @return
     */
    public OrderEntity orderStatus(String orderId) {
        return orderMapper.orderStatus(orderId);
    }

    /**
     * 兑换码验证
     *
     * @param networkId
     * @param code
     * @return
     */
    public ResponseEntity redeemValid(String networkId, String code) {
        String userId = ContextUtils.getCurAuth().getUserId();
        OrderDetailsEntity orderDetailsEntity = orderMapper.redeemProductByCode(code);
        if (orderDetailsEntity == null || !orderDetailsEntity.getNetworkCourseId().equals(networkId)) {
            return new ResponseErrorEntity(StatusCode.REDEEM_EXPIRED, HttpStatus.BAD_REQUEST);
        }
        //剔除已经拥有的网课列表
        List<OrderDetailsEntity> orderDetailList = new ArrayList<>();
        orderDetailList.add(orderDetailsEntity);
        orderDetailList = clearAlreadyNetwork(userId, orderDetailList);
        if (orderDetailList == null || orderDetailList.size() == 0) {
            return new ResponseErrorEntity(StatusCode.ALREADY_BUY_NETWORK, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
