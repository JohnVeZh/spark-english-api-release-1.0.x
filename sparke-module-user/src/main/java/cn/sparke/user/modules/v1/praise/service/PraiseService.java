package cn.sparke.user.modules.v1.praise.service;

import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.user.modules.v1.praise.bean.PraiseBean;
import cn.sparke.user.modules.v1.praise.constants.PraiseConstants;
import cn.sparke.user.modules.v1.praise.mapper.PraiseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * Created by zhangbowen on 2017/7/11.
 */
@Service
public class PraiseService {
    @Autowired
    private PraiseMapper praiseMapper;

    @Transactional
    public void save(PraiseBean praiseBean) {
        if (praiseMapper.existPraise(praiseBean.getUserId(), praiseBean.getContentId()) != null) {
            return;
        }
        praiseBean.preInsert();
        praiseMapper.insert(praiseBean);
        //增加点赞的数量
        switch (praiseBean.getContentType()) {
            case PraiseConstants.TYPE.COMMENT:
                praiseMapper.addCommentPraiseNum(praiseBean.getContentId(), 1);
                break;
            case PraiseConstants.TYPE.ACTIVITY:
                praiseMapper.addActivityPraiseNum(praiseBean.getContentId(), 1);
                break;
        }
    }

    @Transactional
    public void cancel(String contentId) {
        String userId = ContextUtils.getCurAuth().getUserId();
        PraiseBean praiseBean = praiseMapper.existPraise(userId, contentId);
        if (praiseBean == null) {
            return;
        }
        praiseMapper.cancelPraise(userId, contentId);
        //减少点赞的数量
        switch (praiseBean.getContentType()) {
            case PraiseConstants.TYPE.COMMENT:
                praiseMapper.addCommentPraiseNum(praiseBean.getContentId(), -1);
                break;
            case PraiseConstants.TYPE.ACTIVITY:
                praiseMapper.addActivityPraiseNum(praiseBean.getContentId(), -1);
                break;
        }
    }
}
