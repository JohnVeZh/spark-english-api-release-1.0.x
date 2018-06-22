package cn.sparke.user.modules.v1.coupons.service;

import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.user.modules.v1.coupons.bean.*;
import cn.sparke.user.modules.v1.coupons.constants.CouponConstants;
import cn.sparke.user.modules.v1.coupons.mapper.CouponCodeMapper;
import cn.sparke.user.modules.v1.coupons.mapper.CouponGainRecordMapper;
import cn.sparke.user.modules.v1.coupons.mapper.CouponMapper;
import cn.sparke.user.modules.v1.coupons.mapper.CouponRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhangbowen on 2017/7/11.
 */
@Service
public class CouponService {
    @Autowired
    private CouponCodeMapper couponCodeMapper;
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private CouponRuleMapper couponRuleMapper;
    @Autowired
    private CouponGainRecordMapper couponGainRecordMapper;

    /**
     * 领取优惠券
     *
     * @param couponDrawBean
     */
    @Transactional
    public ResponseEntity draw(CouponDrawBean couponDrawBean) {
        String userId = ContextUtils.getCurAuth().getUserId();
        Date curDate = new Date();
        //优惠码
        CouponCodeBean couponCodeBean = null;
        //优惠券规则列表
        List<CouponRuleBean> couponRuleList = new ArrayList<>();
        //如果是优惠码领取优惠券
        if (couponDrawBean.getType() == CouponConstants.TYPE_COUPON_CODE) {
            //获取优惠码信息，判断优惠码是否可用
            couponCodeBean = couponCodeMapper.getByCode(couponDrawBean.getContentId());
            if (couponCodeBean == null || !(couponCodeBean.getEffectDate().before(curDate) && couponCodeBean.getInvalidDate().after(curDate))) {
                return new ResponseErrorEntity(StatusCode.COUPON_CODE_EXPIRED, HttpStatus.BAD_REQUEST);
            }
            //如果领取数量超出最大数量
            if (couponCodeBean.getMaxNum() != 0 && couponCodeBean.getUsedNum() >= couponCodeBean.getMaxNum()) {
                return new ResponseErrorEntity(StatusCode.COUPON_CODE_NUM_SHORTAGE, HttpStatus.BAD_REQUEST);
            }
            //根据优惠码id获取规则列表
            couponRuleList = couponRuleMapper.getRuleListByContentId(couponCodeBean.getId());
            if (couponRuleList.size() == 0) {
                return new ResponseErrorEntity(StatusCode.NOT_FOUND_COUPON_RULE, HttpStatus.NOT_FOUND);
            }
        } else {//如果是通过规则id领取优惠券
            //根据场景id获取规则详情
            CouponRuleBean couponRuleBean = couponRuleMapper.getBySceneId(couponDrawBean.getContentId());
            if (couponRuleBean == null) {
                return new ResponseErrorEntity(StatusCode.COUPON_EXPIRED, HttpStatus.BAD_REQUEST);
            }
            couponRuleList.add(couponRuleBean);
        }
        //此时couponRuleList必然不为空
        //获取用户已领取过的优惠券
        List<String> existGainRuleIdList = couponGainRecordMapper.existGainRuleList(couponRuleList, userId);
        //获取未领取的优惠券规则列表
        List<CouponRuleBean> unGainRuleList = couponRuleList.stream()
                .filter(couponRuleBean -> !existGainRuleIdList.contains(couponRuleBean.getId()))
                .collect(Collectors.toList());
        if (unGainRuleList.size() == 0) {
            //如果未领取的为0
            return new ResponseErrorEntity(StatusCode.EXIST_GAIN_COUPON, HttpStatus.BAD_REQUEST);
        }
        //根据优惠券规则列表，生成优惠券以及领取记录
        List<CouponBean> couponList = new ArrayList<>();
        List<CouponGainRecordBean> gainRecordList = new ArrayList<>();
        unGainRuleList.forEach(rule -> {
            //生成优惠券
            CouponBean couponBean = rule.convertCouponBean(userId);
            couponBean.preInsert();
            couponList.add(couponBean);
            //生成领取记录
            CouponGainRecordBean recordBean = new CouponGainRecordBean();
            recordBean.setUserId(userId);
            recordBean.setCouponId(couponBean.getId());
            recordBean.setGainSceneId(rule.getGainSceneId());
            recordBean.setRuleId(rule.getId());
            recordBean.preInsert();
            gainRecordList.add(recordBean);
        });

        //插入优惠券和领取记录
        couponMapper.batchInsertCoupon(couponList);
        couponGainRecordMapper.batchInsertGainRecord(gainRecordList);

        //如果类型为优惠码，更新优惠码的使用数量
        if (couponDrawBean.getType() == CouponConstants.TYPE_COUPON_CODE && couponCodeBean != null) {
            couponCodeMapper.updateCodeUsedNum(couponCodeBean.getId());
        }
        return new ResponseEntity<>(couponList, HttpStatus.CREATED);
    }
}
