package cn.sparke.base.v1.commonQuestion;

import cn.sparke.base.v1.BaseTest;
import org.junit.Test;
import org.springframework.http.HttpHeaders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class CommonQuestionTest extends BaseTest{
    /**
     * @Description: 常见问题列表
     */
    @Test
    public void questionList() throws Exception {
        this.mockMvc.perform(
                get("/v1/common_questions")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     * @Description: banner详情
     */
    @Test
    public void info() throws Exception {
        this.mockMvc.perform(
                get("/v1/common_questions/b0cbeeea654a11e7a0cf00163e0e8110")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }
}
