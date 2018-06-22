package cn.sparke.base.v1;

import cn.sparke.ModuleBaseApplication;
import cn.sparke.core.modules.cache.CacheFacade;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by zhangbowen on 2017/7/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= ModuleBaseApplication.class)
public class BaseTest {
    @Autowired
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
        CacheFacade.set("9e8e9b00972c4629bd86d8e253779387-APP-TOKEN", "123456", 0);
    }

    public String getBaseHeader() {
        String header = "{" +
                "\"userId\":\"9e8e9b00972c4629bd86d8e253779387\"," +
                "\"token\":\"123456\"," +
                "\"terminal\":\"2\"," +
                "\"versionCode\":\"1\"," +
                "\"sectionCode\":\"1\"" +
                "}";
        return header;
    }
}
