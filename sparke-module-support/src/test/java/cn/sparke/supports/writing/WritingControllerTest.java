package cn.sparke.supports.writing;

import cn.sparke.supports.BaseTest;
import org.apache.http.HttpHeaders;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/8.
 */
public class WritingControllerTest extends BaseTest {
    /**
     */
    @Test
    public void writing_translation() throws Exception {
        this.mockMvc.perform(
                get("/v1/writing_translation").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

}
