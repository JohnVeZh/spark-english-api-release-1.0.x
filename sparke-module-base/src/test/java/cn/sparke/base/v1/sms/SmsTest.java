package cn.sparke.base.v1.sms;

import cn.sparke.base.v1.BaseTest;
import cn.sparke.core.modules.sms.bean.SendCodeBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.util.DigestUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class SmsTest extends BaseTest {
    /**
     * @Description: 发送短信
     */
    @Test
    public void sendSms() throws Exception {
        SendCodeBean sendCodeBean = new SendCodeBean();
        sendCodeBean.setPhone("18764050615");
        sendCodeBean.setType(1);

        this.mockMvc.perform(
                post("/v1/sms").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(sendCodeBean))).andDo(print()).andExpect(status().is2xxSuccessful());

    }

}
