package cn.sparke.user.modules.v1.coupons.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.user.modules.v1.coupons.bean.CouponRuleBean;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public interface CouponRuleMapper extends BaseMapper<CouponRuleBean> {
    /**
     * 根据内容id获取规则列表
     * @param id
     * @return
     */
    List<CouponRuleBean> getRuleListByContentId(String id);

    CouponRuleBean getBySceneId(String sceneId);
}
