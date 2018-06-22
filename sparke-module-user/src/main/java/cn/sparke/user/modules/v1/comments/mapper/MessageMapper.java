package cn.sparke.user.modules.v1.comments.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.user.modules.v1.comments.bean.MessageBean;
import cn.sparke.user.modules.v1.comments.bean.MessageUserBean;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public interface MessageMapper extends BaseMapper<MessageBean> {
    void insertMsgUser(MessageUserBean messageUserBean);
}
