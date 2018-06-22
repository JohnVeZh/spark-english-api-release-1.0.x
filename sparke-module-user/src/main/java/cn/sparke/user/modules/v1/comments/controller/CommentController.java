package cn.sparke.user.modules.v1.comments.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.user.modules.v1.comments.bean.CommentBean;
import cn.sparke.user.modules.v1.comments.bean.CommentReplyBean;
import cn.sparke.user.modules.v1.comments.bean.RequestCommentListBean;
import cn.sparke.user.modules.v1.comments.service.CommentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangbowen on 2017/7/11.
 */
@RestController
@RequestMapping("/${version}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 评论
     *
     * @return
     */
    @PostMapping
    @LoginAnnot
    public ResponseEntity comments(@RequestBody @Validated CommentBean commentBean) {
        commentService.comment(commentBean);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 回复
     *
     * @return
     */
    @PostMapping("/{commentId}/reply")
    @LoginAnnot
    public ResponseEntity reply(@PathVariable String commentId, @RequestBody @Validated CommentReplyBean replyBean) {
        replyBean.setCommentId(commentId);
        replyBean.setUserId(ContextUtils.getCurAuth().getUserId());
        commentService.reply(replyBean);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 评论列表
     *
     * @param requestCommentListBean
     * @return
     */
    @GetMapping
    public ResponseEntity list(@Validated RequestCommentListBean requestCommentListBean) {
        CommentBean commentBean = new CommentBean();
        commentBean.setContentId(requestCommentListBean.getContentId());
        commentBean.setContentType(requestCommentListBean.getContentType());
        if (requestCommentListBean.getRows() != null) {
            commentBean.setRows(requestCommentListBean.getRows() > 20 ? 10 : requestCommentListBean.getRows());
        }
        commentBean.setLoginUserId(ContextUtils.getCurAuth().getUserId());
        commentBean.setStart(requestCommentListBean.getStart());
        return ResponseEntity.ok(commentService.findList(commentBean));
    }

    /**
     * 删除评论
     *
     * @return
     */
    @DeleteMapping("/{commentId}")
    @LoginAnnot
    public ResponseEntity deleteComment(@PathVariable String commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 回复列表
     *
     * @param commentId
     * @return
     */
    @GetMapping("/{commentId}/reply")
    public ResponseEntity replyList(@PathVariable String commentId, @RequestParam Integer start) {
        CommentReplyBean commentReplyBean = new CommentReplyBean();
        commentReplyBean.setStart(start);
        commentReplyBean.setCommentId(commentId);
        return ResponseEntity.ok(commentService.findReplyList(commentReplyBean));
    }
}
