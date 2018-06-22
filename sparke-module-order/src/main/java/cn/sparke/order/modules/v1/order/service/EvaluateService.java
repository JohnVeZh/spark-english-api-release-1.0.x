package cn.sparke.order.modules.v1.order.service;

import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.core.common.mybatis.utils.PagerUtils;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.order.modules.v1.order.entity.EvaluateEntity;
import cn.sparke.order.modules.v1.order.constants.OrderConstants;
import cn.sparke.order.modules.v1.order.entity.OrderDetailsEntity;
import cn.sparke.order.modules.v1.order.mapper.EvaluateMapper;
import cn.sparke.order.modules.v1.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/14.
 */
@Service
@Transactional
public class EvaluateService {
    @Autowired
    private EvaluateMapper evaluateMapper;
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 评价
     *
     * @param evaluateEntity
     */
    public ResponseEntity evaluate(EvaluateEntity evaluateEntity) {
        //判断当前订单
        String userId = ContextUtils.getCurAuth().getUserId();
        //根据订单详情id获取订单详情信息
        OrderDetailsEntity orderDetailsEntity = evaluateMapper.getOrderDetailByUser(userId, evaluateEntity.getOrderDetailId());
        if (orderDetailsEntity == null) {
            return new ResponseErrorEntity(StatusCode.ORDER_CANNOT_EVALUATE, HttpStatus.BAD_REQUEST);
        }
        evaluateEntity.setUserId(userId);
        evaluateEntity.setOrderId(orderDetailsEntity.getOrderId());
        evaluateEntity.setProductId(orderDetailsEntity.getProductId());
        evaluateEntity.setAverageScore((evaluateEntity.getThinkingScore() + evaluateEntity.getStyleScore() + evaluateEntity.getCurriculumScore()) / 3);
        evaluateEntity.preInsert();

        //更新订单详情表的状态
        OrderDetailsEntity updateOrderDetail = new OrderDetailsEntity();
        updateOrderDetail.setId(orderDetailsEntity.getId());
        updateOrderDetail.setIsComment(OrderConstants.ORDER_DETAIL.IS_COMMENT);
        updateOrderDetail.preUpdate();
        //获取所有该商品的评分列表
        List<Integer> allScoreList = evaluateMapper.findScoreByProduct(orderDetailsEntity.getProductId());
        allScoreList.add(evaluateEntity.getAverageScore());
        int productScore = allScoreList.stream().reduce(0, (i, i1) -> i + i1) / allScoreList.size();

        //获取该订单下未评论的订单商品列表
        List<String> orderDetailIdList = evaluateMapper.findNotCommentList(orderDetailsEntity.getOrderId());
        //插入评分
        evaluateMapper.insert(evaluateEntity);
        //修改商品的平均分
        evaluateMapper.updateProductScore(orderDetailsEntity.getProductId(), productScore);
        //更新订单详情表的状态
        orderMapper.updateOrderDetail(updateOrderDetail);
        //如果仅剩一个订单详情并且与当前相同，可修改订单表的状态为已完成
        if (orderDetailIdList.size() == 1 && orderDetailIdList.get(0).equals(orderDetailsEntity.getId())) {
            orderMapper.updateOrderStatus(orderDetailsEntity.getOrderId(), OrderConstants.STATUS.FINISH);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 评价列表
     *
     * @param evaluateEntity
     */
    public PagerBean<EvaluateEntity> findList(EvaluateEntity evaluateEntity) {
        return PagerUtils.getPager(evaluateMapper.findList(evaluateEntity));
    }
}
