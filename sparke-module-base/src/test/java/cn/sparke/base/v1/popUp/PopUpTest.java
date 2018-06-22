package cn.sparke.base.v1.popUp;

import cn.sparke.base.v1.BaseTest;
import org.junit.Test;
import org.springframework.http.HttpHeaders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Ning
 * 2017/8/21.
 */
public class PopUpTest extends BaseTest {
    /**
     * 首页弹窗接口测试
     * @throws Exception
     */
    @Test
    public void getPopUp() throws Exception {
        this.mockMvc.perform(
                get("/v1/popup?showModule=1")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());


    }
}
