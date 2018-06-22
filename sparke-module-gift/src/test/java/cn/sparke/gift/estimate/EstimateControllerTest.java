package cn.sparke.gift.estimate;

import cn.sparke.gift.BaseTest;
import org.junit.Test;
import org.springframework.http.HttpHeaders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EstimateControllerTest extends BaseTest {
    @Test
    public void queryEstimateCatalog() throws Exception {
        this.mockMvc.perform(get("/v1/estimate")
                .header(HttpHeaders.AUTHORIZATION, getBaseHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
