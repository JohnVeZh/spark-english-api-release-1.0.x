package cn.sparke.user.v1.comment;

import cn.sparke.user.BaseTest;
import cn.sparke.user.modules.v1.comments.bean.CommentBean;
import cn.sparke.user.modules.v1.comments.bean.CommentReplyBean;
import cn.sparke.user.modules.v1.favorities.bean.FavoriteBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class CommentTest extends BaseTest{
    /**
     * @Description: 评论
     */
    @Test
    public void comment() throws Exception {
        CommentBean commentBean = new CommentBean();
        //commentBean.setContentId("8a987df759bfe2f8015a20da07ed013d");
        commentBean.setContentId("0fa2670c9dda42038b033a01900b06e8");
        commentBean.setContentType(1);
        commentBean.setImgs("没有图片");
        commentBean.setContent("内容");
        this.mockMvc.perform(
                post("/v1/comments").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .content(JSON.toJSONString(commentBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 回复
     */
    @Test
    public void reply() throws Exception {
        CommentReplyBean replyBean = new CommentReplyBean();
        replyBean.setTargetUserId("f30681ed39ee4c499f925574c40bebb9");
        replyBean.setContent("你好啊");
        this.mockMvc.perform(
                post("/v1/comments/fb583512848b4fbfaac9ee64355bb19b/reply").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .content(JSON.toJSONString(replyBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 评论列表
     */
    @Test
    public void commentList() throws Exception {
        this.mockMvc.perform(
                get("/v1/comments?start=0&contentType=2&contentId=8a987df75bf89bf5015bfbd9737100a3").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 网课评论列表
     */
    @Test
    public void netCourseCommentList() throws Exception {
        this.mockMvc.perform(
                get("/v1/comments?start=0&contentType=1&contentId=4c65eb2a18564abd8d711d357b06eeb2").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }


    /**
     * @Description: 回复列表
     */
    @Test
    public void replyList() throws Exception {
        this.mockMvc.perform(
                get("/v1/comments/fb583512848b4fbfaac9ee64355bb19b/reply?start=0").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }
    /**
     * @Description: 删除回复
     */
    @Test
    public void deleteReply() throws Exception {
        this.mockMvc.perform(
                delete("/v1/comments/reply/a68fdd5ddff9416d9a6ebf373980acc7").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
