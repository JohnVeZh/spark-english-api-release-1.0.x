package cn.sparke.gift.estimate;

import cn.sparke.gift.BaseTest;
import org.junit.Test;
import org.springframework.http.HttpHeaders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EstimateReportControllerTest extends BaseTest {
    @Test
    public void learningProgram()throws Exception {
        this.mockMvc.perform(get("/v1/estimate/report/339f6ee581c74af2959981a04774cc76")
                .header(HttpHeaders.AUTHORIZATION, getBaseHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
