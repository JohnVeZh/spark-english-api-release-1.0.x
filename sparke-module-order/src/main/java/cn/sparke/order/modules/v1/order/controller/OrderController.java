package cn.sparke.order.modules.v1.order.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.order.modules.v1.order.bean.PostOrderBean;
import cn.sparke.order.modules.v1.order.bean.RedeemBean;
import cn.sparke.order.modules.v1.order.bean.RefundBean;
import cn.sparke.order.modules.v1.order.entity.EvaluateEntity;
import cn.sparke.order.modules.v1.order.entity.OrderEntity;
import cn.sparke.order.modules.v1.order.service.EvaluateService;
import cn.sparke.order.modules.v1.order.service.OrderService;
import cn.sparke.order.modules.v1.order.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

/**
 * Created by zhangbowen on 2017/7/12.
 */
@RestController
@RequestMapping("/${version}")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RefundService refundService;
    @Autowired
    private EvaluateService evaluateService;

    /**
     * 确认订单
     *
     * @return
     */
    @PostMapping("/confirm")
    @LoginAnnot
    public ResponseEntity confirmOrder(@RequestBody @Validated PostOrderBean postOrderBean) {
        return orderService.confirmOrder(postOrderBean);
    }

    /**
     * 提交订单
     *
     * @return
     */
    @PostMapping
    @LoginAnnot
    public ResponseEntity postOrder(@RequestBody @Validated PostOrderBean postOrderBean) {
        return orderService.postOrder(postOrderBean);
    }

    /**
     * 验证兑换码是否存在
     *
     * @return
     */
    @GetMapping("/redeem/{networkId}/{code}")
    @LoginAnnot
    public ResponseEntity redeemValid(@PathVariable String networkId, @PathVariable String code) {
        return orderService.redeemValid(networkId, code);
    }

    /**
     * 兑换码兑换
     *
     * @return
     */
    @PostMapping("/redeem")
    @LoginAnnot
    public ResponseEntity redeemValid(@RequestBody @Validated RedeemBean redeemBean) {
        return orderService.redeemNetwork(redeemBean);
    }

    /**
     * 订单详情
     *
     * @return
     */
    @GetMapping("/{orderId}")
    @LoginAnnot
    public ResponseEntity orderInfo(@PathVariable String orderId) {
        String userId = ContextUtils.getCurAuth().getUserId();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderId);
        orderEntity.setUserId(userId);
        return ResponseEntity.ok(orderService.info(orderEntity));
    }

    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    @PutMapping("/{orderId}/cancel")
    @LoginAnnot
    public ResponseEntity cancelOrder(@PathVariable String orderId) {
        orderService.cancel(orderId);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 确认收货
     *
     * @param orderId
     * @return
     */
    @PutMapping("/{orderId}/cargo_confirm")
    @LoginAnnot
    public ResponseEntity cargo_confirm(@PathVariable String orderId) {
        orderService.cargo_confirm(orderId);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 删除订单
     *
     * @param orderId
     * @return
     */
    @DeleteMapping("/{orderId}")
    @LoginAnnot
    public ResponseEntity deleteOrder(@PathVariable String orderId) {
        return orderService.deleteOrder(orderId);
    }

    /**
     * 退货详情
     *
     * @return
     */
    @GetMapping("/{orderDetailId}/refund")
    @LoginAnnot
    public ResponseEntity refundInfo(@PathVariable String orderDetailId) {
        return ResponseEntity.ok(refundService.refundInfo(orderDetailId));
    }

    /**
     * 退货申请
     *
     * @return
     */
    @PostMapping("/refund")
    @LoginAnnot
    public ResponseEntity refund(@RequestBody @Validated RefundBean refundBean) {
        return refundService.refund(refundBean);
    }

    /**
     * 评价
     *
     * @return
     */
    @PostMapping("/evaluates")
    @LoginAnnot
    public ResponseEntity evaluates(@RequestBody @Validated EvaluateEntity evaluateEntity) {
        return evaluateService.evaluate(evaluateEntity);
    }

    /**
     * 评价列表
     *
     * @return
     */
    @GetMapping("/evaluates")
    public ResponseEntity evaluates(@RequestParam Integer start, @RequestParam String productId) {
        EvaluateEntity evaluateEntity = new EvaluateEntity();
        evaluateEntity.setProductId(productId);
        evaluateEntity.setStart(start);
        return ResponseEntity.ok(evaluateService.findList(evaluateEntity));
    }

    /**
     * 订单状态查询
     *
     * @return
     */
    @GetMapping("/{orderId}/status")
    @LoginAnnot
    public ResponseEntity orderStatus(@PathVariable String orderId) {
        return ResponseEntity.ok(orderService.orderStatus(orderId));
    }
}
