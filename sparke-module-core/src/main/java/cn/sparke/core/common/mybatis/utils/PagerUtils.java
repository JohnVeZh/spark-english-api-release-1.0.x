package cn.sparke.core.common.mybatis.utils;

import cn.sparke.core.common.mybatis.bean.ConvertCountSqlBean;
import com.github.pagehelper.Page;
import cn.sparke.core.common.mybatis.bean.PagerBean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangbowen on 2017/5/4.
 */
@SuppressWarnings("unchecked")
public class PagerUtils {
    /**
     * 获得pager
     *
     * @return
     */
    public static <T> PagerBean<T> getPager(Page<T> page) {
        PagerBean pagerBean = new PagerBean();
        pagerBean.setData(page);
        pagerBean.setTotal(page.getTotal());
        return pagerBean;
    }


}
