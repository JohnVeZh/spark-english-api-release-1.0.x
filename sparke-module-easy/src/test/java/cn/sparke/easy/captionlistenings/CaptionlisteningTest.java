package cn.sparke.easy.captionlistenings;

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
public class CaptionlisteningTest extends BaseTest{

    /**
     * @Description: 查询字幕听力分页列表
     */
    @Test
    public void captionListenings() throws Exception {
        this.mockMvc.perform(
                get("/v1/easy/caption_listenings?start=0")
                        .header(org.apache.http.HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION,getBaseHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
