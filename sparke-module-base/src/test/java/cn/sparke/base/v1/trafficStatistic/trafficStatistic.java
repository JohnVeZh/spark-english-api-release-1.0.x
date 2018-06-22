package cn.sparke.base.v1.trafficStatistic;

import cn.sparke.base.modules.v1.fragment.bean.FeedbackBean;
import cn.sparke.base.modules.v1.fragment.bean.QuestionErrorBean;
import cn.sparke.base.v1.BaseTest;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class trafficStatistic extends BaseTest {
    /**
     * @Description: 流量统计
     */
    @Test
    public void trafficStatistic() throws Exception {
        this.mockMvc.perform(
                get("/v1/trafficStatistic?channelCode=1&operationType=2&fromType=1")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }

}
