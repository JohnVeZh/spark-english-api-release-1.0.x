package cn.sparke.gift.estimate;

import cn.sparke.gift.BaseTest;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EstimateSkipControllerTest  extends BaseTest {

    @Test
    public void learningProgram()throws Exception {
        this.mockMvc.perform(get("/v1/study_scheme")
                .header(HttpHeaders.AUTHORIZATION, getBaseHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void recommendCourse() throws  Exception{
        this.mockMvc.perform(get("/v1/study_scheme/4")
                .header(HttpHeaders.AUTHORIZATION, getBaseHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void submitScheme()throws Exception{
        Map<String,String> map=new HashMap<>();
        map.put("id","1");
        this.mockMvc.perform(post("/v1/study_scheme")
                .contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(map))
                .header(HttpHeaders.AUTHORIZATION, getBaseHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
