package cn.sparke.special;

import cn.sparke.SpecialApplication;
import cn.sparke.core.modules.cache.CacheFacade;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Administrator on 2017/7/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpecialApplication.class)
public class BaseTest {
    @Autowired
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;
    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
        CacheFacade.set("8a987df75be866e8015beadbc02612c4-APP-TOKEN", "123456", 0);
    }

    public String getBaseHeader() {
        String header = "{" +
                "\"userId\":\"8a987df75be866e8015beadbc02612c4\"," +
                "\"token\":\"123456\"," +
                "\"terminal\":\"1\"," +
                "\"version\":\"1\"," +
                "\"sectionCode\":\"1\"" +
                "}";
        return header;
    }


}
