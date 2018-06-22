package cn.sparke.community.v1;

import cn.sparke.BaseTest;
import org.junit.Test;
import org.springframework.http.HttpHeaders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by yangye on 2017/7/14.
 */
public class NewsTest extends BaseTest {

    public static final String URL_PREFIX = "/v1/communitys/news";


    /**
     * @Description: 获取资讯列表
     */
    @Test
    public void findList() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "?start=1").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 查询资讯详情
     */
    @Test
    public void getById() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "/4411471865d511e7a0cf00163e0e1220").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 推荐资讯详情
     */
    @Test
    public void getRecommendList() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "/recommend_list?start=1").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
