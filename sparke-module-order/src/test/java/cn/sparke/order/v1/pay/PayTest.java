package cn.sparke.order.v1.pay;

import cn.sparke.BaseTest;
import cn.sparke.order.modules.v1.order.bean.PostOrderBean;
import cn.sparke.order.modules.v1.order.bean.PostOrderProductBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/14.
 */
public class PayTest extends BaseTest {
    /**
     * @Description: 提交订单
     */
    @Test
    public void save() throws Exception {
        this.mockMvc.perform(
                post("/v1/pay/ali/callback?outTradeNo=201707141648296704&tradeNo=12121").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
