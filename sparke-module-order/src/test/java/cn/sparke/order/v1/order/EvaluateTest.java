package cn.sparke.order.v1.order;

import cn.sparke.BaseTest;
import cn.sparke.order.modules.v1.order.bean.RefundBean;
import cn.sparke.order.modules.v1.order.entity.EvaluateEntity;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/14.
 */
public class EvaluateTest extends BaseTest {
    /**
     * @Description: 订单评价
     */
    @Test
    public void insert() throws Exception {
        EvaluateEntity evaluateEntity = new EvaluateEntity();
        evaluateEntity.setOrderDetailId("0148a3862efc4247960fe97e2a189cf5");
        evaluateEntity.setContent("一点都不好看");
        evaluateEntity.setStyleScore(2);
        evaluateEntity.setThinkingScore(2);
        evaluateEntity.setCurriculumScore(3);
        this.mockMvc.perform(
                post("/v1/evaluates").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .content(JSON.toJSONString(evaluateEntity))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 商品评价列表
     */
    @Test
    public void evaluates() throws Exception {
        this.mockMvc.perform(
                get("/v1/evaluates?start=0&productId=0afc82b465d111e7a0cf00163e0e8115").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
