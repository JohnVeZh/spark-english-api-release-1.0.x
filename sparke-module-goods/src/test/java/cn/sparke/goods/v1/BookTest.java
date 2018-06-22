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
public class BookTest extends BaseTest {

    public static final String URL_PREFIX = "/v1/books";

    /**
     * @Description: 获取图书类型列表
     */
    @Test
    public void getBookTypeList() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "/types?start=1").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     * @Description: 获取图书列表
     */
    @Test
    public void findList() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "?start=1&typeId=3ef1855f65d111e7a0cf00163e0e9110").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 根据图书id查询图书详情
     */
    @Test
    public void getById() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "/436ca9ea65d111e7a0cf00163e0e7003").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
