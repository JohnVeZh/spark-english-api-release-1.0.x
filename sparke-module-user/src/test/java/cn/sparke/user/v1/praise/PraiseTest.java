package cn.sparke.user.v1.praise;

import cn.sparke.user.BaseTest;
import cn.sparke.user.modules.v1.attentions.bean.AttentionBean;
import cn.sparke.user.modules.v1.praise.bean.PraiseBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class PraiseTest extends BaseTest {
    /**
     * @Description: 新增
     */
    @Test
    public void save() throws Exception {
        PraiseBean praiseBean = new PraiseBean();
        praiseBean.setContentId("fb583512848b4fbfaac9ee64355bb19b");
        praiseBean.setContentType(1);
        this.mockMvc.perform(
                post("/v1/praise").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .content(JSON.toJSONString(praiseBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 取消点赞
     */
    @Test
    public void favoritesDelete() throws Exception {
        this.mockMvc.perform(
                delete("/v1/praise/fb583512848b4fbfaac9ee64355bb19b").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
