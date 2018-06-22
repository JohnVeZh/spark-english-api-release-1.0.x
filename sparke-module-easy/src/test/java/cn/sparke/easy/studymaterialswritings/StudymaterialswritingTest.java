package cn.sparke.easy.studymaterialswritings;

import cn.sparke.easy.BaseTest;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wanghaiguang on 2017/7/11.
 */
public class StudymaterialswritingTest extends BaseTest {
    /**
     * @Description: 根据参数代表类型查询写作翻译阅读分页列表
     */
    @Test
    public void study_materials_writings() throws Exception {
        this.mockMvc.perform(
                get("/v1/easy/study_materials_writings?start=1&type=2")
                        .header(org.apache.http.HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION,getBaseHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 根据Id查询写作翻译阅读内容
     */
    @Test
    public void study_materials_writingById() throws Exception {
        this.mockMvc.perform(
                get("/v1/easy/study_materials_writings/f2b7d7d65659984c01565db75c300006")
                        .header(org.apache.http.HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION,getBaseHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
