package cn.sparke.user;

import cn.sparke.ModuleUserApplication;
import cn.sparke.core.modules.cache.CacheFacade;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by zhangbowen on 2017/7/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ModuleUserApplication.class)
public class BaseTest {
    @Autowired
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
        CacheFacade.set("c76b49d6fc4941a29ff39ef2e46e8374-APP-TOKEN", "123456", 0);
    }

    public String getBaseHeader() {
        String header = "{" +
                "\"userId\":\"c76b49d6fc4941a29ff39ef2e46e8374\"," +
                "\"token\":\"123456\"," +
                "\"terminal\":\"2\"," +
                //"\"terminal\":\"4\"," +
                "\"versionCode\":\"1\"," +
                "\"sectionCode\":\"1\"" +
                "}";
        return header;
    }
}
