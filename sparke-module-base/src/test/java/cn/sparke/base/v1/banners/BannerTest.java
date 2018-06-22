package cn.sparke.base.v1.banners;

import cn.sparke.base.v1.BaseTest;
import org.junit.Test;
import org.springframework.http.HttpHeaders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class BannerTest extends BaseTest{
    /**
     * @Description: banner列表
     */
    @Test
    public void banners() throws Exception {
        this.mockMvc.perform(
                get("/v1/banners?moduleType=1")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }
    /**
     * @Description: 大礼包banner列表
     */
    @Test
    public void giftBanners() throws Exception {
        this.mockMvc.perform(
                get("/v1/banners?moduleType=4")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     * @Description: banner详情
     */
    @Test
    public void info() throws Exception {
        this.mockMvc.perform(
                get("/v1/banners/11416381654811e7a0cf00163e0e8110")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }
}
