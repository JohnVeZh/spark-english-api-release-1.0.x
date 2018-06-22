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
public class ActivityTest extends BaseTest {

    public static final String URL_PREFIX = "/v1/communitys/activitys";

    /**
     * @Description: 获取活动列表
     */
    @Test
    public void findList() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "?start=1").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 查询活动详情
     */
    @Test
    public void getById() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "/8a987df759bfe2f8015a11ef43d300a7").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

}
