package cn.sparke.user.modules.v1.attentions.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.user.modules.v1.attentions.bean.AttentionActivityBean;
import cn.sparke.user.modules.v1.attentions.bean.AttentionBean;
import com.github.pagehelper.Page;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public interface AttentionMapper extends BaseMapper<AttentionBean> {
    String existActivity(String contentId);

    String existAttention(AttentionBean attentionBean);

    void cancelAttention(AttentionBean attentionBean);

    Page<AttentionActivityBean> findListByActivity(AttentionBean attentionBean);
}
