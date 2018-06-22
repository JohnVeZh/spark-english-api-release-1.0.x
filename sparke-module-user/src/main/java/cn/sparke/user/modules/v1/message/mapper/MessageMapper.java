package cn.sparke.user.modules.v1.message.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.user.modules.v1.message.bean.MessageBean;
import cn.sparke.user.modules.v1.message.bean.MessageUserOperateBean;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public interface MessageMapper extends BaseMapper<MessageBean> {
    /**
     * 插入用户操作
     *
     * @param messageBean
     */
    void insertUserOperate(MessageUserOperateBean messageBean);

    /**
     * 更新用户操作
     *
     * @param messageBean
     */
    void updateUserOperate(MessageUserOperateBean messageBean);

    /**
     * 判断是否存在用户操作
     *
     * @param messageBean
     */
    MessageUserOperateBean existUserOperate(MessageUserOperateBean messageBean);

    /**
     * 判断是否存在未读消息
     *
     * @param messageBean
     * @return
     */
    String existUnReadMsg(MessageBean messageBean);
}
