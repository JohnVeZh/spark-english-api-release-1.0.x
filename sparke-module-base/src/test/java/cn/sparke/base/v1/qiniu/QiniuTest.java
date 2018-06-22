package cn.sparke.base.v1.qiniu;

import cn.sparke.base.v1.BaseTest;
import org.junit.Test;
import org.springframework.http.HttpHeaders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class QiniuTest extends BaseTest{
    /**
     * @Description: qiniu
     */
    @Test
    public void qiniuSign() throws Exception {
        this.mockMvc.perform(
                get("/v1/qiniu/sign?key=1")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }
}
