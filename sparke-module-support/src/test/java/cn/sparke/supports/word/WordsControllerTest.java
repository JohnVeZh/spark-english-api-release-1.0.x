package cn.sparke.supports.word;

import cn.sparke.supports.BaseTest;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/8.
 */
public class WordsControllerTest extends BaseTest {
    /**
     */
    @Test
    public void wordsCatalogs() throws Exception {
        this.mockMvc.perform(
                get("/v1/words/catalogs").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    @Test
    public void word() throws Exception {
        this.mockMvc.perform(
                get("/v1/words/catalogs/402880ea54c665860133333333").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    @Test
    public void newWord() throws Exception {
        this.mockMvc.perform(
                post("/v1/words/news/50027").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    @Test
    public void delete_newWord() throws Exception {
        this.mockMvc.perform(
                delete("/v1/words/news/3").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }
    @Test
    public void newWordList() throws Exception {
        this.mockMvc.perform(
                get("/v1/words/news").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

}
