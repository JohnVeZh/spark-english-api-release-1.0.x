package cn.sparke.user.modules.v1.comments.service;

import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.core.common.mybatis.utils.PagerUtils;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.user.modules.v1.comments.bean.CommentBean;
import cn.sparke.user.modules.v1.comments.bean.CommentReplyBean;
import cn.sparke.user.modules.v1.comments.bean.MessageBean;
import cn.sparke.user.modules.v1.comments.bean.MessageUserBean;
import cn.sparke.user.modules.v1.comments.constants.CommentConstants;
import cn.sparke.user.modules.v1.comments.constants.MessageConstants;
import cn.sparke.user.modules.v1.comments.mapper.CommentMapper;
import cn.sparke.user.modules.v1.comments.mapper.MessageMapper;
import cn.sparke.user.modules.v1.message.service.MessageService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by zhangbowen on 2017/7/11.
 */
@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 评论
     */
    public void comment(CommentBean commentBean) {
        //插入评论
        String userId = ContextUtils.getCurAuth().getUserId();
        int terminal = ContextUtils.getCurAuth().getTerminal();
        String contentId = commentBean.getContentId();
        if (commentBean.getContentType() == CommentConstants.TYPE.NETWORK) {
            //是否拥有网课
            String hasNetwork = commentMapper.hasNetwork(userId, contentId);
            //不是pc
            if (terminal != CommentConstants.TERMINAL_TYPE.PC) {
                //如果为网课评论，判断是否拥有网课
                if (hasNetwork == null) {
                    return;
                }
            } else {//PC。如果是免费的，可以评论，不是免费的，判断该用户是否购买，没有购买不能评论
                Integer isFree = commentMapper.isFreeNetWork(contentId);
                if (CommentConstants.NETWORK_IS_FREE.NO_FREE == isFree) {
                    if (hasNetwork == null) {
                        return;
                    }
                }
            }

        }
        commentBean.setUserId(userId);
        commentBean.preInsert();
        commentMapper.insert(commentBean);
        //更新评论数量
        switch (commentBean.getContentType()) {
            case CommentConstants.TYPE.NETWORK:
                commentMapper.addNetworkCommentNum(contentId);
                break;
            case CommentConstants.TYPE.NEWS:
                commentMapper.addNewsCommentNum(contentId);
                break;
            case CommentConstants.TYPE.ACTIVITY:
                commentMapper.addActivityCommentNum(contentId);
                break;
        }
    }

    /**
     * 回复
     *
     * @param replyBean
     */
    @Transactional
    public void reply(CommentReplyBean replyBean) {
        //根据评论id获取活动id
        String activityId = commentMapper.getContentIdByCommentId(replyBean.getCommentId());
        if (activityId == null) {
            return;
        }
        replyBean.preInsert();
        commentMapper.insertReply(replyBean);
        //更新评论数量
        commentMapper.addCommentReplyNum(replyBean.getCommentId());
        //插入到消息中
        MessageBean messageBean = new MessageBean();
        messageBean.setTitle("您的评论收到新回复，点击查看");
        messageBean.setContentId(activityId);
        messageBean.setJumpType(MessageConstants.JUMP_TYPE.ACTIVITY);
        messageBean.setTargetType(MessageConstants.TARGET_TYPE.PERSONAL);
        messageBean.preInsert();

        MessageUserBean messageUserBean = new MessageUserBean();
        messageUserBean.setUserId(replyBean.getUserId());
        messageUserBean.setMsgId(messageBean.getId());
        messageUserBean.preInsert();

        messageMapper.insert(messageBean);
        messageMapper.insertMsgUser(messageUserBean);

    }

    /**
     * 评论列表
     *
     * @param commentBean
     * @return
     */
    public PagerBean findList(CommentBean commentBean) {
        Page<CommentBean> list;
        if (commentBean.getContentType() == CommentConstants.TYPE.NETWORK) {//如果是网课，返回回复列表
            list = commentMapper.findNetWorkReplyList(commentBean);
        } else {
            list = commentMapper.findList(commentBean);
        }
        return PagerUtils.getPager(list);
    }

    /**
     * 查询回复列表
     *
     * @param commentReplyBean
     * @return
     */
    public PagerBean findReplyList(CommentReplyBean commentReplyBean) {
        return PagerUtils.getPager(commentMapper.findReplyList(commentReplyBean));
    }

    public void deleteComment(String commentId) {
        String userId = ContextUtils.getCurAuth().getUserId();
        CommentBean query = new CommentBean();
        query.setId(commentId);
        query.setUserId(userId);
        CommentBean commentBean = commentMapper.get(query);
        if (commentBean == null) {
            return;
        }
        commentMapper.delete(commentId);
        commentMapper.subtractActivityCommentNum(commentBean.getContentId());
    }
}
