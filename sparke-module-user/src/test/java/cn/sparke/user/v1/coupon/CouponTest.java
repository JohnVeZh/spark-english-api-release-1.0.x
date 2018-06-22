package cn.sparke.user.v1.coupon;

import cn.sparke.user.BaseTest;
import cn.sparke.user.modules.v1.coupons.bean.CouponDrawBean;
import cn.sparke.user.modules.v1.favorities.bean.FavoriteBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public class CouponTest extends BaseTest {
    /**
     * @Description: 领取优惠券
     */
    @Test
    public void draw() throws Exception {
        CouponDrawBean couponDrawBean = new CouponDrawBean();
        couponDrawBean.setContentId("1234");
        couponDrawBean.setType(1);
        this.mockMvc.perform(
                post("/v1/coupons/draw").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .content(JSON.toJSONString(couponDrawBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
