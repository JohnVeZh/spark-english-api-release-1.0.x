package cn.sparke.gift;

import cn.sparke.gift.modules.v1.activationCode.bean.ActivationCodeBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by asknico on 2017-08-21.
 */
public class ActivationCodeTest extends BaseTest {

    /**
     * 是否首页激活大礼包
     */
    @Test
    public void isActivated() throws Exception {
        this.mockMvc.perform(get("/v1/activation_codes/is_activated").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * 激活码描述
     */
    @Test
    public void description() throws Exception {
        this.mockMvc.perform(get("/v1/activation_codes/3M5JY2V2/description").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * 激活码激活
     */
    @Test
    public void activate() throws Exception {
        ActivationCodeBean codeBean = new ActivationCodeBean();
        codeBean.setCode("3JC55EFN");
        codeBean.setAddress("山东省济南市历下区舜泰广场8号楼15层");
        this.mockMvc.perform(post("/v1/activation_codes/activate").characterEncoding("UTF-8").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(codeBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }


}
