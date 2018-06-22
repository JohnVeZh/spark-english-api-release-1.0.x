package cn.sparke.gift.estimate;

import cn.sparke.gift.BaseTest;
import cn.sparke.gift.modules.v1.estimate.bean.vo.ObjectiveAnswerVo;
import cn.sparke.gift.modules.v1.estimate.bean.vo.SubjectiveAnswerVo;
import cn.sparke.gift.modules.v1.estimate.bean.vo.SubjectiveAnswerVoDetailIdVo;
import cn.sparke.gift.modules.v1.estimate.bean.vo.SubmitAnswerVo;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EstimateSubmitController extends BaseTest {

    @Test
    public void oneself() throws Exception {
        SubmitAnswerVo submitAnswerVo = new SubmitAnswerVo();
        List<ObjectiveAnswerVo> listenAnswers = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            ObjectiveAnswerVo o = new ObjectiveAnswerVo();
            o.setNo(i);
            o.setAnswer("A");
            listenAnswers.add(o);
        }
        submitAnswerVo.setListenAnswers(listenAnswers);

        List<ObjectiveAnswerVo> readAnswers = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            ObjectiveAnswerVo o = new ObjectiveAnswerVo();
            o.setNo(i);
            o.setAnswer("A");
            readAnswers.add(o);
        }
        submitAnswerVo.setReadAnswers(readAnswers);
        SubjectiveAnswerVo translationAnswerVo = new SubjectiveAnswerVo();
        translationAnswerVo.setAnswer("答案");
        translationAnswerVo.setNo(51);

        List<SubjectiveAnswerVoDetailIdVo> answerRules = Lists.newArrayList();
        for (int i = 1; i <= 4; i++) {
            SubjectiveAnswerVoDetailIdVo o = new SubjectiveAnswerVoDetailIdVo();
            o.setRuleId("1");
            o.setRuleDetailId("1");
            answerRules.add(o);
        }
        translationAnswerVo.setAnswerRules(answerRules);

        submitAnswerVo.setTranslationAnswers(translationAnswerVo);
        SubjectiveAnswerVo writingAnswerVo = new SubjectiveAnswerVo();
        writingAnswerVo.setAnswer("答案");
        writingAnswerVo.setNo(52);

        List<SubjectiveAnswerVoDetailIdVo> writing = Lists.newArrayList();
        for (int i = 1; i <= 5; i++) {
            SubjectiveAnswerVoDetailIdVo o = new SubjectiveAnswerVoDetailIdVo();
            o.setRuleId("1");
            o.setRuleDetailId("1");
            writing.add(o);
        }
        writingAnswerVo.setAnswerRules(writing);

        submitAnswerVo.setWritingAnswers(writingAnswerVo);

        String jsonStr = JSON.toJSONString(submitAnswerVo);
        this.mockMvc.perform(post("/v1/estimate/c8206d70e0a049f8a46c59f1f2a6e95c")
                .header(HttpHeaders.AUTHORIZATION, getTokeHeader("8a987df75c8b61cf015c910163167298"))
                .content(jsonStr)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



    @Test
    public void submitJson() throws Exception {
        String json = "{\"readAnswers\":[{\"no\":26,\"answer\":\"A\"},{\"no\":27,\"answer\":\"A\"},{\"no\":28,\"answer\":\"\"},{\"no\":29,\"answer\":\"\"},{\"no\":30,\"answer\":\"\"},{\"no\":31,\"answer\":\"\"},{\"no\":32,\"answer\":\"\"},{\"no\":33,\"answer\":\"\"},{\"no\":34,\"answer\":\"\"},{\"no\":35,\"answer\":\"\"},{\"no\":36,\"answer\":\"\"},{\"no\":37,\"answer\":\"\"},{\"no\":38,\"answer\":\"\"},{\"no\":39,\"answer\":\"\"},{\"no\":40,\"answer\":\"\"},{\"no\":41,\"answer\":\"\"},{\"no\":42,\"answer\":\"\"},{\"no\":43,\"answer\":\"\"},{\"no\":44,\"answer\":\"\"},{\"no\":45,\"answer\":\"\"},{\"no\":46,\"answer\":\"\"},{\"no\":47,\"answer\":\"\"},{\"no\":48,\"answer\":\"\"},{\"no\":49,\"answer\":\"\"},{\"no\":50,\"answer\":\"\"},{\"no\":51,\"answer\":\"\"},{\"no\":52,\"answer\":\"\"},{\"no\":53,\"answer\":\"\"},{\"no\":54,\"answer\":\"\"},{\"no\":55,\"answer\":\"\"}],\"writingAnswers\":{\"answer\":\"\",\"no\":57},\"listenAnswers\":[{\"no\":1,\"answer\":\"A\"},{\"no\":2,\"answer\":\"A\"},{\"no\":3,\"answer\":\"\"},{\"no\":4,\"answer\":\"\"},{\"no\":5,\"answer\":\"\"},{\"no\":6,\"answer\":\"\"},{\"no\":7,\"answer\":\"\"},{\"no\":8,\"answer\":\"\"},{\"no\":9,\"answer\":\"\"},{\"no\":10,\"answer\":\"\"},{\"no\":11,\"answer\":\"\"},{\"no\":12,\"answer\":\"\"},{\"no\":13,\"answer\":\"\"},{\"no\":14,\"answer\":\"\"},{\"no\":15,\"answer\":\"\"},{\"no\":16,\"answer\":\"\"},{\"no\":17,\"answer\":\"\"},{\"no\":18,\"answer\":\"\"},{\"no\":19,\"answer\":\"\"},{\"no\":20,\"answer\":\"\"},{\"no\":21,\"answer\":\"\"},{\"no\":22,\"answer\":\"\"},{\"no\":23,\"answer\":\"\"},{\"no\":24,\"answer\":\"\"},{\"no\":25,\"answer\":\"\"}],\"translationAnswers\":{\"answer\":\"\",\"no\":56}}";
        this.mockMvc.perform(post("/v1/estimate/b08d084ce58f4b1dab2aba1565d815a3")
                .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void not_oneself() throws Exception {
        SubmitAnswerVo submitAnswerVo = new SubmitAnswerVo();
        List<ObjectiveAnswerVo> listenAnswers = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            ObjectiveAnswerVo o = new ObjectiveAnswerVo();
            o.setNo(i);
            o.setAnswer("A");
            listenAnswers.add(o);
        }
        submitAnswerVo.setListenAnswers(listenAnswers);

        List<ObjectiveAnswerVo> readAnswers = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            ObjectiveAnswerVo o = new ObjectiveAnswerVo();
            o.setNo(i);
            o.setAnswer("A");
            readAnswers.add(o);
        }
        submitAnswerVo.setReadAnswers(readAnswers);
        SubjectiveAnswerVo translationAnswerVo = new SubjectiveAnswerVo();
        translationAnswerVo.setAnswer("答案");
        translationAnswerVo.setNo(51);
        submitAnswerVo.setTranslationAnswers(translationAnswerVo);
        SubjectiveAnswerVo writingAnswerVo = new SubjectiveAnswerVo();
        writingAnswerVo.setAnswer("答案");
        writingAnswerVo.setNo(52);
        submitAnswerVo.setWritingAnswers(writingAnswerVo);

        String jsonStr = JSON.toJSONString(submitAnswerVo);
        this.mockMvc.perform(post("/v1/estimate/c8206d70e0a049f8a46c59f1f2a6e95c")
                .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                .content(jsonStr)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
