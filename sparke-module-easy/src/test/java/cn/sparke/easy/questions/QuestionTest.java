package cn.sparke.easy.questions;

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
public class QuestionTest extends BaseTest {
    /**
     * @Description: //根据试卷结构Id(structureId),获取简系列试卷题目列表
     */
    @Test
    public void questions() throws Exception {
        this.mockMvc.perform(
                get("/v1/easy/questions?structureId=df87b9efd3ed11e68bac00163e4554f4")
                        .header(org.apache.http.HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION,getBaseHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 根据题目Id(questionId)和题目类型(type),获取题目详情
     */
    @Test
    public void queryByIdAndType() throws Exception {
        this.mockMvc.perform(
                get("/v1/easy/questions/df87b9efd3ed11e68bac00163e455499?type=1")
                        .header(org.apache.http.HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION,getBaseHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



}
