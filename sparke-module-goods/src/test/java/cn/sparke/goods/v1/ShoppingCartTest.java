package cn.sparke.goods.v1;

import cn.sparke.BaseTest;
import cn.sparke.goods.modules.v1.networkCourse.bean.UserNetworkCourseBean;
import cn.sparke.goods.modules.v1.shoppingCart.bean.ProductShoppingCartBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by yangye on 2017/7/14.
 */
public class ShoppingCartTest extends BaseTest {

    public static final String URL_PREFIX = "/v1/shopping_carts";

    /**
     * @Description: 添加购物车
     */
    @Test
    public void insert() throws Exception {
        ProductShoppingCartBean cartBean = new ProductShoppingCartBean();
//        cartBean.setUserId("8a987df75a6a023c015a6b5e59d40acd");
        cartBean.setProductId("0afc82b465d111e7a0cf00163e0e8113");
        cartBean.setProductNum(3);
        this.mockMvc.perform(post(URL_PREFIX ).characterEncoding("UTF-8").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(cartBean))).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     * @Description: 修改购物车
     */
    @Test
    public void update() throws Exception {
        ProductShoppingCartBean cartBean = new ProductShoppingCartBean();
        cartBean.setId("3ef1855f65d111e7a0cf00163e0e9201");
        cartBean.setProductNum(3);
        this.mockMvc.perform(put(URL_PREFIX ).characterEncoding("UTF-8").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(cartBean))).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     * @Description: 删除购物车
     */
    @Test
    public void deleteCart() throws Exception {
        ProductShoppingCartBean cartBean = new ProductShoppingCartBean();
        cartBean.setId("3ef1855f65d111e7a0cf00163e0e9201");
        this.mockMvc.perform(delete(URL_PREFIX).characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, getBaseHeader()).content(JSON.toJSONString(cartBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }


    /**
     * @Description: 获取购物车列表
     */
    @Test
    public void findList() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "?start=1&userId=f30681ed39ee4c499f925574c40bebb9").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 获取用户购物车数量
     */
    @Test
    public void getShoppingCartNum() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "/nums/f30681ed39ee4c499f925574c40bebb9").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }




}
