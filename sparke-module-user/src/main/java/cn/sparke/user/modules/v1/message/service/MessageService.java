package cn.sparke.user.modules.v1.message.service;

import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.core.common.mybatis.utils.PagerUtils;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.user.modules.v1.message.bean.MessageBean;
import cn.sparke.user.modules.v1.message.bean.MessageUserOperateBean;
import cn.sparke.user.modules.v1.message.constants.MessageConstants;
import cn.sparke.user.modules.v1.message.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

/**
 * Created by zhangbowen on 2017/7/11.
 */
@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 消息列表
     *
     * @param messageBean
     * @return
     */
    public PagerBean findList(MessageBean messageBean) {
        String userId = ContextUtils.getCurAuth().getUserId();
        messageBean.setUserId(userId);
        //获取消息列表
        return PagerUtils.getPager(messageMapper.findList(messageBean));
    }

    /**
     * 判断是否存在用户对消息的操作
     *
     * @param userId
     * @param msgId
     * @return
     */
    private MessageUserOperateBean existOperate(String userId, String msgId) {
        MessageUserOperateBean existOperation = new MessageUserOperateBean();
        existOperation.setUserId(userId);
        existOperation.setId(msgId);
        return messageMapper.existUserOperate(existOperation);
    }

    /**
     * 消息详情
     *
     * @param id
     * @return
     */
    public MessageBean info(String id) {
        MessageBean messageBean = messageMapper.getById(id);
        if (messageBean == null) {
            return null;
        }
        //判断用户是否对该条消息操作过
        String userId = ContextUtils.getCurAuth().getUserId();
        MessageUserOperateBean existOperate = existOperate(userId, id);
        if (existOperate == null) {
            //插入用户已经读取
            MessageUserOperateBean insertOperate = new MessageUserOperateBean();
            insertOperate.setMsgId(id);
            insertOperate.setUserId(userId);
            insertOperate.setType(MessageConstants.TYPE.READ);
            insertOperate.preInsert();
            messageMapper.insertUserOperate(insertOperate);
        }
        return messageMapper.getById(id);
    }

    /**
     * 判断是否存在新消息
     *
     * @return
     */
    public ResponseEntity new_message_exist() {
        String userId = ContextUtils.getCurAuth().getUserId();
        MessageBean messageBean = new MessageBean();
        messageBean.setUserId(userId);
        String messageId = messageMapper.existUnReadMsg(messageBean);
        if (messageId == null) {//如果不存在新消息，返回404
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {//存在返回200
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    /**
     * 删除消息
     *
     * @param id
     */
    public void deleteMsg(String userId, String id) {
        //判断消息是否存在
        MessageBean messageBean = messageMapper.getById(id);
        if (messageBean == null) {
            return;
        }
        MessageUserOperateBean messageUserOperateBean = existOperate(userId, id);
        if (messageUserOperateBean == null) {
            //如果没有操作过，则新增
            MessageUserOperateBean insert = new MessageUserOperateBean();
            insert.setUserId(userId);
            insert.setType(MessageConstants.TYPE.DELETE);
            insert.setMsgId(id);
            insert.preInsert();
            messageMapper.insertUserOperate(insert);
        } else {
            //如果已经阅读过，更新
            if (messageUserOperateBean.getType() == MessageConstants.TYPE.READ) {
                MessageUserOperateBean update = new MessageUserOperateBean();
                update.setType(MessageConstants.TYPE.DELETE);
                update.setId(messageUserOperateBean.getId());
                update.preUpdate();
                messageMapper.updateUserOperate(update);
            }
        }
    }
}
