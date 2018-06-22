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
public class  TakeControllerTest extends BaseTest {
    /**
     */
    @Test
    public void take() throws Exception {
        this.mockMvc.perform(
                get("/v1/take/goods").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

}
