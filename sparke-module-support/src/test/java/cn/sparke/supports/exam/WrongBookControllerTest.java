package cn.sparke.supports.exam;

import cn.sparke.support.modules.v1.exam.bean.wrongbook.vo.WrongBooks;
import cn.sparke.support.modules.v1.exam.mapper.WrongBookMapper;
import cn.sparke.supports.BaseTest;
import org.apache.http.HttpHeaders;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class WrongBookControllerTest extends BaseTest {

    @Resource
    private WrongBookMapper wrongBookMapper;
    @Test
    public void wrong_books2() throws Exception {
        List<WrongBooks> wrongBooksList = wrongBookMapper.findWrongBook("8a987df758a9291c0158a9762bfe08e2",2);
        System.out.printf("");
    }

    /**
     */
    @Test
    public void wrong_books() throws Exception {
        this.mockMvc.perform(
                get("/v1/exam/wrong_books").header(HttpHeaders.AUTHORIZATION, getdbHeader("8eb84194f15d48db97e9106d03e9f891")).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     */
    @Test
    public void get_wrong_books() throws Exception {
        this.mockMvc.perform(
                get("/v1/exam/wrong_books/2803d20691cb11e793086c92bf20e479").header(HttpHeaders.AUTHORIZATION, getdbHeader("9b6830d2d48948d9b2a1ea711b051a63")).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     */
    @Test
    public void get_wrong_books2() throws Exception {
        this.mockMvc.perform(
                get("/v1/exam/wrong_books").header(HttpHeaders.AUTHORIZATION, getdbHeader("8a987df75b45fdc8015b6043fc504198")).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }
    /**
     */
    @Test
    public void recommend() throws Exception {
        this.mockMvc.perform(
                get("/v1/exam/wrong_books/recommend").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     */
    @Test
    public void recommendDati() throws Exception {
        this.mockMvc.perform(
                get("/v1/exam/wrong_books/recommend/f2b785da5cf2fe21015d1ab98cca000b").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

}
