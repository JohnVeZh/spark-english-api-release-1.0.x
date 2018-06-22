package cn.sparke.community.modules.v1.utils;

import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.core.common.mybatis.utils.PagerUtils;
import com.github.pagehelper.PageInfo;

/**
 * Created by yangye on 2017/7/11.
 */
public class MyPageUtil extends PagerUtils {

    // 获取分页后的实体
    public static <T> PagerBean<T> getPagerBean(PageInfo<T> page) {
        PagerBean pagerBean = new PagerBean();
        pagerBean.setData(page.getList());
        pagerBean.setTotal(page.getTotal());
        return pagerBean;
    }
}
