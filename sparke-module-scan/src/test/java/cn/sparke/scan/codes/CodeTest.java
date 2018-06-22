package cn.sparke.scan.codes;


import cn.sparke.scan.BaseTest;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wanghaiguang on 2017/7/11.
 */
public class CodeTest extends BaseTest {
    /**
     * @Description: 根据二维码(qr_code),获取详情
     */
    @Test
    public void codeScan() throws Exception {
        this.mockMvc.perform(
                get("/v1/codes?qr_code=DTJ161-4")
                        .header(org.apache.http.HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION,getBaseHeader()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }







}
