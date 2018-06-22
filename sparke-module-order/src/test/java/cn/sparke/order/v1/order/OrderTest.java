package cn.sparke.order.v1.order;

import cn.sparke.BaseTest;
import cn.sparke.order.modules.v1.order.bean.PostOrderBean;
import cn.sparke.order.modules.v1.order.bean.PostOrderProductBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public class OrderTest extends BaseTest {
    /**
     * @Description: 提交订单
     */
    @Test
    public void save() throws Exception {
        PostOrderBean postOrderBean = new PostOrderBean();
//        postOrderBean.setAddressId("c4b903902f4640f5ba9f1fedd3cfe865");
//        postOrderBean.setCouponId("062b999eb09548f4a0a64a61b1433483");
        postOrderBean.setType(1);
        List<PostOrderProductBean> productBeanList = new ArrayList<>();
//        PostOrderProductBean postOrderProductBean = new PostOrderProductBean();
//        postOrderProductBean.setProductId("0afc82b465d111e7a0cf00163e0e8114");
//        postOrderProductBean.setShoppingCarId("4ef1855f65d111e7a0cf00163e0e9200");
//        postOrderProductBean.setProductNum(788);
//        productBeanList.add(postOrderProductBean);

        PostOrderProductBean postOrderProductBean2 = new PostOrderProductBean();
        postOrderProductBean2.setProductId("8a987df75be78ec1015bed01c9270406");
//        postOrderProductBean2.setShoppingCarId("4ef1855f65d111e7a0cf00163e0e9200");
        postOrderProductBean2.setProductNum(1);
        productBeanList.add(postOrderProductBean2);
        postOrderBean.setProductList(productBeanList);
        this.mockMvc.perform(
                post("/v1").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .content(JSON.toJSONString(postOrderBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }


    /**
     * @Description: 确认订单
     */
    @Test
    public void confirm() throws Exception {
        PostOrderBean postOrderBean = new PostOrderBean();
        postOrderBean.setType(1);
        List<PostOrderProductBean> productBeanList = new ArrayList<>();
//        PostOrderProductBean postOrderProductBean = new PostOrderProductBean();
//        postOrderProductBean.setProductId("0afc82b465d111e7a0cf00163e0e8114");
//        postOrderProductBean.setShoppingCarId("4ef1855f65d111e7a0cf00163e0e9200");
//        postOrderProductBean.setProductNum(788);
//        productBeanList.add(postOrderProductBean);

        PostOrderProductBean postOrderProductBean2 = new PostOrderProductBean();
        postOrderProductBean2.setProductId("0afc82b465d111e7a0cf00163e0e8116");
        postOrderProductBean2.setProductNum(1);
        productBeanList.add(postOrderProductBean2);
        postOrderBean.setProductList(productBeanList);
        this.mockMvc.perform(
                post("/v1/confirm").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .content(JSON.toJSONString(postOrderBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 兑换码获取
     */
    @Test
    public void redeem() throws Exception {
        this.mockMvc.perform(
                post("/v1/redeem/1234").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 详情
     */
    @Test
    public void info() throws Exception {
        this.mockMvc.perform(
                get("/v1/c339d49d62904fc784931e02da57fac5").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 取消订单
     */
    @Test
    public void cancelOrder() throws Exception {
        this.mockMvc.perform(
                put("/v1/2d282c2d4e50487890236b918789ba96/cancel").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 删除订单
     */
    @Test
    public void deleteOrder() throws Exception {
        this.mockMvc.perform(
                put("/v1/2d282c2d4e50487890236b918789ba96").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
