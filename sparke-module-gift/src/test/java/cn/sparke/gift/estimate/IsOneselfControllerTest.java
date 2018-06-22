package cn.sparke.gift.estimate;

import cn.sparke.gift.BaseTest;
import cn.sparke.gift.modules.v1.estimate.bean.vo.RuleVo;
import cn.sparke.gift.modules.v1.estimate.mapper.TbGiftSubjectiveRuleMapper;
import org.junit.Test;
import org.springframework.http.HttpHeaders;

import javax.annotation.Resource;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class IsOneselfControllerTest extends BaseTest {

    @Resource
    private TbGiftSubjectiveRuleMapper tbGiftSubjectiveRuleMapper;


    @Test
    public void is_oneself3() throws Exception {
        String header = "{\"sectionCode\":1,\"terminal\":1,\"token\":\"3105d58a9e6f9e5d6018d082c2deb6d6\",\"userId\":\"8a987df75c169470015c47d290b31f26\",\"version\":\"1.0\"}\n";
        this.mockMvc.perform(get("/v1/estimate/b08d084ce58f4b1dab2aba1565d815a3/is_oneself")
                .header(HttpHeaders.AUTHORIZATION, header))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    @Test
    public void is_oneself() throws Exception {
        this.mockMvc.perform(get("/v1/estimate/c8206d70e0a049f8a46c59f1f2a6e95c/is_oneself")
                .header(HttpHeaders.AUTHORIZATION, getTokeHeader("8a987df75c169470015c47d290b31f26")))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void is_oneself2() throws Exception {
        List<RuleVo> ruleVoList = tbGiftSubjectiveRuleMapper.findRuleDetailsVo(1, "c8206d70e0a049f8a46c59f1f2a6e95c");
        System.out.println("ruleVoList");
    }
}
