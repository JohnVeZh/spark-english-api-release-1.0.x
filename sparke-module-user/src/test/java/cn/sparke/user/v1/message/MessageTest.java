package cn.sparke.user.v1.message;

import cn.sparke.user.BaseTest;
import cn.sparke.user.modules.v1.favorities.bean.FavoriteBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class MessageTest extends BaseTest{
    /**
     * @Description: 消息列表
     */
    @Test
    public void favoritesList() throws Exception {
        this.mockMvc.perform(
                get("/v1/messages?start=0").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }
    /**
     * @Description: 是否存在新消息
     */
    @Test
    public void new_message_exist() throws Exception {
        this.mockMvc.perform(
                get("/v1/messages/new_message_exist").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 消息详情
     */
    @Test
    public void info() throws Exception {
        this.mockMvc.perform(
                get("/v1/messages/f0efcbcc65eb11e7a0cf00163e0e8110").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 删除消息
     */
    @Test
    public void deleteMsg() throws Exception {
        this.mockMvc.perform(
                delete("/v1/messages/f0efcbcc65eb11e7a0cf00163e0e8110").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
