package cn.sparke.base.modules.v1.fragment.service;

import cn.sparke.base.modules.v1.fragment.bean.QuestionErrorBean;
import cn.sparke.base.modules.v1.fragment.mapper.QuestionErrorMapper;
import cn.sparke.core.common.utils.ContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangbowen on 2017/7/10.
 */
@Service
public class QuestionErrorService {
    @Autowired
    private QuestionErrorMapper questionErrorMapper;

    public void questionError(QuestionErrorBean questionErrorBean) {
        questionErrorBean.preInsert();
        questionErrorBean.setUserId(ContextUtils.getCurAuth().getUserId());
        questionErrorMapper.insert(questionErrorBean);
    }
}
