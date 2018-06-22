package cn.sparke.base.modules.v1.banners.service;

import cn.sparke.base.modules.v1.banners.bean.BannerBean;
import cn.sparke.base.modules.v1.banners.mapper.BannerMapper;
import cn.sparke.base.modules.v1.banners.mapper.CouponRuleMapper;
import cn.sparke.core.common.utils.ContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/10.
 */
@Service
public class BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Autowired
    private CouponRuleMapper couponRuleMapper;

    /**
     * banner列表
     *
     * @param bannerBean
     * @return
     */
    public List<BannerBean> findList(BannerBean bannerBean) {
        return bannerMapper.findList(bannerBean);
    }

    /**
     * banner 详情
     *
     * @param id
     * @return
     */
    public BannerBean info(String id) {
        BannerBean bannerBean = bannerMapper.getById(id);
        if (bannerBean == null) {
            return null;
        }
        String userId = ContextUtils.getCurAuth().getUserId();
        bannerBean.setCouponRuleList(couponRuleMapper.findRuleListByScene(id,userId));
        return bannerBean;
    }
}
