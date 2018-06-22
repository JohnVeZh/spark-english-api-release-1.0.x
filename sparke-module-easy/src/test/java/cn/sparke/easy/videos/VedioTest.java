package cn.sparke.easy.videos;

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
public class VedioTest extends BaseTest {

    /**
     * @Description: 根据catalogId查询简视频分页列表
     */
    @Test
    public void videos() throws Exception {
        this.mockMvc.perform(
                get("/v1/easy/videos/f2b7d7d65671e6a401771a01015678?start=1")
                        .header(org.apache.http.HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION,getBaseHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
