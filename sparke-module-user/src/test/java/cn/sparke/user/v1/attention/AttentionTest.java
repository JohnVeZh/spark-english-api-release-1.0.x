package cn.sparke.user.v1.attention;

import cn.sparke.user.BaseTest;
import cn.sparke.user.modules.v1.attentions.bean.AttentionBean;
import cn.sparke.user.modules.v1.favorities.bean.FavoriteBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class AttentionTest extends BaseTest {
    /**
     * @Description: 新增关注
     */
    @Test
    public void save() throws Exception {
        AttentionBean attentionBean = new AttentionBean();
        attentionBean.setContentId("8a987df759bfe2f8015a20da07ed011d");
        attentionBean.setContentType(1);
        this.mockMvc.perform(
                post("/v1/attentions").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .content(JSON.toJSONString(attentionBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 收藏列表
     */
    @Test
    public void favoritesList() throws Exception {
        this.mockMvc.perform(
                get("/v1/attentions?start=0").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 取消关注
     */
    @Test
    public void favoritesDelete() throws Exception {
        this.mockMvc.perform(
                delete("/v1/attentions/8a987df759bfe2f8015a20da07ed011d").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
