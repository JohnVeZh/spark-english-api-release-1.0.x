package cn.sparke;

import cn.sparke.core.modules.cache.CacheFacade;
import cn.sparke.core.modules.token.constants.TokenConstants;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by yangye on 2017/7/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CommunityApplication.class)
public class BaseTest {

    @Autowired
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
        CacheFacade.set("f2b7d7d6566815be0156689727cd00c6" + TokenConstants.TOKEN_SUFFIX.APP, "123456", 0);
    }

    public String getBaseHeader() {
        String header = "{" +
                "\"userId\":\"f2b7d7d6566815be0156689727cd00c6\"," +
                "\"token\":\"123456\"," +
                "\"terminal\":\""+TokenConstants.TERMINAL.ANDROID+"\"," +
                "\"versionCode\":\"1\"," +
                "\"sectionCode\":\"1\"" +
                "}";
        return header;
    }
}
