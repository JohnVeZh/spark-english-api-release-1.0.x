package cn.sparke.user.modules.v1.coupons.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.user.modules.v1.coupons.bean.CouponGainRecordBean;
import cn.sparke.user.modules.v1.coupons.bean.CouponRuleBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public interface CouponGainRecordMapper extends BaseMapper<CouponGainRecordBean> {
    List<String> existGainRuleList(@Param("list") List<CouponRuleBean> ruleList, @Param("userId") String userId);

    /**
     * 批量插入优惠券领取记录
     * @param gainRecordList
     */
    void batchInsertGainRecord(List<CouponGainRecordBean> gainRecordList);
}
