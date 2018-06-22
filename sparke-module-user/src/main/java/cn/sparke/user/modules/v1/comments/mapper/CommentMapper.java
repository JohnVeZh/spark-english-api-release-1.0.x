package cn.sparke.user.modules.v1.comments.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.user.modules.v1.comments.bean.CommentBean;
import cn.sparke.user.modules.v1.comments.bean.CommentReplyBean;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public interface CommentMapper extends BaseMapper<CommentBean> {
    String hasNetwork(@Param("userId") String userId, @Param("contentId") String contentId);

    //新增网课评论数量
    void addNetworkCommentNum(String contentId);

    //新增资讯评论数量
    void addNewsCommentNum(String contentId);

    //新增活动评论数量
    void addActivityCommentNum(String contentId);

    //新增评论回复数量
    void addCommentReplyNum(String contentId);

    //新增回复
    void insertReply(CommentReplyBean commentReplyBean);

    //减少活动评论数量
    void subtractActivityCommentNum(String activityId);

    //查询回复列表
    Page<CommentReplyBean> findReplyList(CommentReplyBean commentReplyBean);

    //根据评论id获取活动id
    String getContentIdByCommentId(String commentId);

    Page<CommentBean> findNetWorkReplyList(CommentBean commentBean);

    //网课是否免费
    Integer isFreeNetWork(String contentId);

}
