package cn.sparke.user.v1.favorites;

import cn.sparke.user.BaseTest;
import cn.sparke.user.modules.v1.favorities.bean.FavoriteBean;
import cn.sparke.user.modules.v1.users.bean.ChangePwdBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class FavoriteTest extends BaseTest {
    /**
     * @Description: 新增收藏
     */
    @Test
    public void favoritesSave() throws Exception {
        FavoriteBean favoriteBean = new FavoriteBean();
        favoriteBean.setTargetId("4411471865d511e7a0cf00163e0e8110");
        favoriteBean.setType(1);
        this.mockMvc.perform(
                post("/v1/favorites").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .content(JSON.toJSONString(favoriteBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 收藏列表
     */
    @Test
    public void favoritesList() throws Exception {
        this.mockMvc.perform(
                get("/v1/favorites/1?start=0").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 取消收藏
     */
    @Test
    public void favoritesDelete() throws Exception {
        List<FavoriteBean> list = new ArrayList<>();
        FavoriteBean favoriteBean = new FavoriteBean();
        favoriteBean.setTargetId("4411471865d511e7a0cf00163e0e8110");
        list.add(favoriteBean);
        this.mockMvc.perform(
                delete("/v1/favorites").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .content(JSON.toJSONString(list))).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
