package cn.sparke.base.modules.v1.banners.mapper;

import cn.sparke.base.modules.v1.banners.bean.CouponRuleBean;
import cn.sparke.core.common.mybatis.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/10.
 * 优惠券规则
 */
public interface CouponRuleMapper extends BaseMapper<CouponRuleBean> {
    /**
     * 根据内容id获取规则列表
     *
     * @param contentId
     * @return
     */
    List<CouponRuleBean> findRuleListByScene(@Param("contentId") String contentId, @Param("userId") String userId);
}
