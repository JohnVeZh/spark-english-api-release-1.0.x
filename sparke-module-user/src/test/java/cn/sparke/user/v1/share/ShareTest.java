package cn.sparke.user.v1.share;

import cn.sparke.user.BaseTest;
import cn.sparke.user.modules.v1.praise.bean.PraiseBean;
import cn.sparke.user.modules.v1.share.bean.ShareBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class ShareTest extends BaseTest {
    /**
     * @Description: 分享
     */
    @Test
    public void share() throws Exception {
//        ShareBean shareBean = new ShareBean();
//        shareBean.setContent("111");
//        this.mockMvc.perform(
//                post("/v1/share").characterEncoding("UTF-8")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
//                        .content(JSON.toJSONString(shareBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
