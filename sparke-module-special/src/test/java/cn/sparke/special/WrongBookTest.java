package cn.sparke.special;

import cn.sparke.special.modules.v1.question.bean.QuestionBean;
import cn.sparke.special.modules.v1.report.bean.QuestionReportBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Administrator on 2017/7/19.
 */
public class WrongBookTest extends BaseTest {



    @Test
    /**
     * 错题本列表
     */
    public void findBookList() throws Exception {
        this.mockMvc.perform(
                get("/v1/wrong_books?start=0&type=1")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }
    @Test
    /**
     * 错题本题目详情
     */
    public void findBook() throws Exception {
        this.mockMvc.perform(
                get("/v1/wrong_books/4e865511632c4c6c8546e5d127c5295e?type=1")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }

}
