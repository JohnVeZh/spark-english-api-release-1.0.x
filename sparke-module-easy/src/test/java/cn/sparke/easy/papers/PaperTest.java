package cn.sparke.easy.papers;

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
public class PaperTest extends BaseTest {
    /**
     * @Description: 根据试卷目录Id(paperCatalogId),获取简系列试卷列表
     */
    @Test
    public void papers() throws Exception {
        this.mockMvc.perform(
                get("/v1/easy/papers?start=1&paperCatalogId=113D3A746BA24A67610D72508CBFB473")
                        .header(org.apache.http.HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION,getBaseHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 根据试卷Id(paperId),获取简系列试卷结构
     */
    @Test
    public void queryPaperStructureBypaperId() throws Exception {
        this.mockMvc.perform(
                get("/v1/easy/papers/df87b9efd3ed11e68bac00163e0c8sd4/structure")
                        .header(org.apache.http.HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION,getBaseHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
