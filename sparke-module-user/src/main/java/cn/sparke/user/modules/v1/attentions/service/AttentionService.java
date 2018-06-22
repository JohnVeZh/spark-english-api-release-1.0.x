package cn.sparke.user.modules.v1.attentions.service;

import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.core.common.mybatis.utils.PagerUtils;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.user.modules.v1.attentions.bean.AttentionBean;
import cn.sparke.user.modules.v1.attentions.constants.AttentionConstants;
import cn.sparke.user.modules.v1.attentions.mapper.AttentionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangbowen on 2017/7/11.
 */
@Service
public class AttentionService {
    @Autowired
    private AttentionMapper attentionMapper;

    /**
     * 关注
     *
     * @param attentionBean
     */
    public void save(AttentionBean attentionBean) {
        String userId = ContextUtils.getCurAuth().getUserId();
        attentionBean.setUserId(userId);
        //判断是否存在该关注，存在不关注
        if (attentionMapper.existAttention(attentionBean) != null) {
            return;
        }
        attentionBean.preInsert();
        attentionMapper.insert(attentionBean);
    }

    /**
     * 取消关注
     *
     * @param contentId
     */
    public void cancelAttention(String contentId) {
        String userId = ContextUtils.getCurAuth().getUserId();
        AttentionBean attentionBean = new AttentionBean();
        attentionBean.setUserId(userId);
        attentionBean.setContentId(contentId);
        attentionMapper.cancelAttention(attentionBean);
    }

    /**
     * 关注列表
     *
     * @param attentionBean
     */
    public PagerBean findList(AttentionBean attentionBean) {
        return PagerUtils.getPager(attentionMapper.findListByActivity(attentionBean));
    }
}
