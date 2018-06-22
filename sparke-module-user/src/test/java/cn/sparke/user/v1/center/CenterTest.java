package cn.sparke.user.v1.center;

import cn.sparke.user.BaseTest;
import cn.sparke.user.modules.v1.center.bean.UserInfo;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public class CenterTest extends BaseTest {
    /**
     * @Description: 我的回复列表
     */
    @Test
    public void replyList() throws Exception {
        this.mockMvc.perform(
                get("/v1/center/comments/reply?start=0").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 我的订单
     */
    @Test
    public void orderList() throws Exception {
        this.mockMvc.perform(
                get("/v1/center/orders/1?start=1&orderStatus=7").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 我的网课
     */
    @Test
    public void network_course() throws Exception {
        this.mockMvc.perform(
                get("/v1/center/my_courses_list?start=0&courseType=1").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 我的优惠券
     */
    @Test
    public void coupons() throws Exception {
        this.mockMvc.perform(
                get("/v1/center/coupons?start=0&status=1").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }


    /**
     * @Description: 个人详情
     */
    @Test
    public void userInfo() throws Exception {
        this.mockMvc.perform(
                get("/v1/center/info").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }


    /**
     * @Description: 修改个人信息
     */
    @Test
    public void updateUserInfo() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setNickname("你好啊");

        this.mockMvc.perform(
                put("/v1/center/info").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader()
                        ).content(JSON.toJSONString(userInfo))).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
