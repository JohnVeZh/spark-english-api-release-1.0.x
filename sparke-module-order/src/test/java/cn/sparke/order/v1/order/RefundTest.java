package cn.sparke.order.v1.order;

import cn.sparke.BaseTest;
import cn.sparke.order.modules.v1.order.bean.RefundBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/13.
 */
public class RefundTest extends BaseTest {
    /**
     * @Description: 退货申请
     */
    @Test
    public void insert() throws Exception {
        RefundBean refundBean = new RefundBean();
        refundBean.setOrderDetailId("d3da02715ad944048834b50646da3786");
        refundBean.setReason("一点都不好看");
        refundBean.setUserReceiveStatus(0);
        refundBean.setType(1);
        this.mockMvc.perform(
                post("/v1/refund").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .content(JSON.toJSONString(refundBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 退货申请
     */
    @Test
    public void info() throws Exception {
        this.mockMvc.perform(
                get("/v1/d3da02715ad944048834b50646da3786/refund").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        ).andDo(print()).andExpect(status().is2xxSuccessful());
    }

}
