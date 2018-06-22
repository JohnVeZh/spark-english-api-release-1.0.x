package cn.sparke.base.modules.v1.fragment.service;

import cn.sparke.base.modules.v1.fragment.bean.FeedbackBean;
import cn.sparke.base.modules.v1.fragment.mapper.FeedbackMapper;
import cn.sparke.core.common.utils.ContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangbowen on 2017/7/10.
 */
@Service
public class FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;

    public void feedback(FeedbackBean feedbackBean) {
        feedbackBean.preInsert();
        feedbackBean.setUserId(ContextUtils.getCurAuth().getUserId());
        feedbackMapper.insert(feedbackBean);
    }
}
