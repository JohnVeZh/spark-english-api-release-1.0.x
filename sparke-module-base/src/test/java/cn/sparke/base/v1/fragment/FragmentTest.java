package cn.sparke.base.v1.fragment;

import cn.sparke.base.modules.v1.fragment.bean.FeedbackBean;
import cn.sparke.base.modules.v1.fragment.bean.QuestionErrorBean;
import cn.sparke.base.v1.BaseTest;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.DigestUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class FragmentTest extends BaseTest {
    /**
     * @Description: 版本获取
     */
    @Test
    public void version() throws Exception {
        this.mockMvc.perform(
                get("/v1/fragment/version")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     * @Description: 启动
     */
    @Test
    public void start() throws Exception {
        this.mockMvc.perform(
                get("/v1/fragment/start")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 意见反馈
     */
    @Test
    public void suggest() throws Exception {
        FeedbackBean feedbackBean = new FeedbackBean();
        feedbackBean.setContent("你们好");
        feedbackBean.setEmail("515445681@qq.com");
        this.mockMvc.perform(
                post("/v1/fragment/suggest").characterEncoding("UTF-8")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(feedbackBean))).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     * @Description: 学段列表
     */
    @Test
    public void sections() throws Exception {
        this.mockMvc.perform(
                get("/v1/fragment/sections")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     * @Description: 题目报错
     */
    @Test
    public void questionError() throws Exception {
        QuestionErrorBean questionErrorBean = new QuestionErrorBean();
        questionErrorBean.setPaperId("123456");
        questionErrorBean.setSectionCode(1);
        questionErrorBean.setContent("这个题目有问题");
        questionErrorBean.setType(1);
        this.mockMvc.perform(
                post("/v1/fragment/error/111").characterEncoding("UTF-8")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(questionErrorBean))).andDo(print()).andExpect(status().is2xxSuccessful());

    }
}
