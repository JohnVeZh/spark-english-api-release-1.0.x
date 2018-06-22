package cn.sparke.supports.caption;

import cn.sparke.supports.BaseTest;
import org.apache.http.HttpHeaders;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/8.
 */
public class PaperControllerTest extends BaseTest {
    /**
     */
    @Test
    public void caption_hearing() throws Exception {
        this.mockMvc.perform(
                get("/v1/caption_hearing/catalog/papers").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }
    /**
     */
    @Test
    public void putPapers() throws Exception {
        this.mockMvc.perform(
                put("/v1/caption_hearing/papers/21").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     */
    @Test
    public void getUserPapers() throws Exception {
        this.mockMvc.perform(
                get("/v1/caption_hearing/papers/user").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     */
    @Test
    public void papers() throws Exception {
        this.mockMvc.perform(
                get("/v1/caption_hearing/8a987df75cb0382b015d1ffca3911d2e/papers").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }
}
