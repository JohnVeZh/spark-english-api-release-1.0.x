package cn.sparke.gift;

import org.junit.Test;
import org.springframework.http.HttpHeaders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by asknico on 2017-08-21.
 */
public class RecommendCourseTest extends BaseTest {

    /**
     * 课程推荐详情
     */
    @Test
    public void detailsBySectionCode() throws Exception {
        this.mockMvc.perform(get("/v1/recommend_course/details").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }


}
