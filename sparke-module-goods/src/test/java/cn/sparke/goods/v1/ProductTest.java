package cn.sparke.goods.v1;

import cn.sparke.BaseTest;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by yangye on 2017/7/14.
 */
public class ProductTest extends BaseTest {

    public static final String URL_PREFIX = "/v1/goods";

    /**
     * @Description: 根据商品id、商品类型，查询商品详情
     */
    @Test
    public void getById() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "/8a987df75905d10501590606b2a60001?productType=2").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
