package cn.sparke.gift;

import cn.sparke.SparkeGiftApplication;
import cn.sparke.core.modules.cache.CacheFacade;
import cn.sparke.core.modules.token.utils.TokenUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by zhangbowen on 2017/7/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SparkeGiftApplication.class)
public class BaseTest {
    @Autowired
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
        CacheFacade.set("302c1f6316904ee595962c6ed38f5cd8-APP-TOKEN", "123456", 0);
    }

    public String getBaseHeader() {
        String header = "{" +
                "\"userId\":\"302c1f6316904ee595962c6ed38f5cd8\"," +
                "\"token\":\"123456\"," +
                "\"terminal\":\"1\"," +
                "\"version\":\"1\"," +
                "\"sectionCode\":\"1\"" +
                "}";
        return header;
    }


    public String getdbHeader() {
        int terminal = 1;
        String userId = "8a987df75c169470015c47d290b31f26";
        String suffix = TokenUtils.getSuffix(terminal);
        String token = CacheFacade.getObject(userId + suffix);

        String header = "{" +
                "\"userId\":\"" + userId + "\"," +
                "\"token\":\"" + token + "\"," +
                "\"terminal\":\"" + terminal + "\"," +
                "\"version\":\"1\"," +
                "\"sectionCode\":\"1\"" +
                "}";
        return header;
    }

    public String getTokeHeader(String userId) {
        int terminal = 1;
        String suffix = TokenUtils.getSuffix(terminal);
        String token = CacheFacade.getObject(userId + suffix);

        String header = "{" +
                "\"userId\":\"" + userId + "\"," +
                "\"token\":\"" + token + "\"," +
                "\"terminal\":\"" + terminal + "\"," +
                "\"version\":\"1\"," +
                "\"sectionCode\":\"1\"" +
                "}";
        return header;
    }
}
