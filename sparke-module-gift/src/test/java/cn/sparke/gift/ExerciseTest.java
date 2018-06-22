package cn.sparke.gift;

import cn.sparke.gift.modules.v1.exercise.bean.QuestionBean;
import cn.sparke.gift.modules.v1.exercise.bean.QuestionItemBean;
import cn.sparke.gift.modules.v1.exercise.bean.QuestionReportBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Administrator on 2017/8/21.
 */
public class ExerciseTest extends BaseTest{

    /**
     * 练习列表
     */
    @Test
    public void exercises() throws Exception {
        this.mockMvc.perform(
                get("/v1/exercises?start=0")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }
    /**
     * 题目详情
     */
    @Test
    public void question() throws Exception {
        this.mockMvc.perform(
                get("/v1/exercises/e9bf6289e46d4f5391da37ce5af0ea7e?type=1")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }
    /**
     * 阅读翻译中途退出
     */
    @Test
    public void quit() throws  Exception{
        QuestionReportBean questionReportBean = new QuestionReportBean();
        questionReportBean.setPaperId("412ca5b286d711e7b07e6c92bf2c1455");
        questionReportBean.setPaperStructureId("0102016");
        questionReportBean.setUseTime(360);
        questionReportBean.setContentType(1);
        QuestionBean questionBean = new QuestionBean();
        questionBean.setId("e9bf6289e46d4f5391da37ce5af0ea7e");
        questionBean.setQuestionNum(2);
        List<QuestionItemBean> itemBeanList = new ArrayList<>();
        QuestionItemBean itemBean = new QuestionItemBean();
        itemBean.setId("fd2dfb7a06ca458aa535a5e663020bfd");
        itemBean.setUserOptionId("c24a2bd5dbfd4fdaa275c0ea6870b131");
        itemBeanList.add(itemBean);
        questionBean.setQuestionItemList(itemBeanList);
        questionReportBean.setQuestion(questionBean);
        this.mockMvc.perform(
                post("/v1/exercises/quit").characterEncoding("UTF-8")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(questionReportBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }
    /**
     * 翻译写作交卷
     */
    @Test
    public void submit() throws  Exception{
        QuestionReportBean translationReportBean = new QuestionReportBean();
        translationReportBean.setContentType(3);
        translationReportBean.setPaperId("df87b9efd3ed11e68bac00163r5c8sf4");
        translationReportBean.setPaperStructureId("df87b9efd3ed11e68bac00163r5crdgb");
        QuestionBean questionBean = new QuestionBean();
        questionBean.setId("df87b9efd3ed11e68bac00163e422345");
        questionBean.setQuestionNum(1);
        questionBean.setDifficultyLevel(1);
        translationReportBean.setQuestion(questionBean);

        this.mockMvc.perform(
                post("/v1/exercises/submit").characterEncoding("UTF-8")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(translationReportBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * 交卷
     * @throws Exception
     */
    @Test
    public void submit_paper() throws  Exception{
        QuestionReportBean questionReportBean = new QuestionReportBean();
        questionReportBean.setPaperId("412ca5b286d711e7b07e6c92bf2c1455");
        questionReportBean.setPaperStructureId("0102016");
        questionReportBean.setUseTime(360);
        questionReportBean.setContentType(2);
        questionReportBean.setTotalNum(2);
        questionReportBean.setDidNum(2);
        questionReportBean.setNotDoneNum(0);
        QuestionBean questionBean = new QuestionBean();
        questionBean.setId("e9bf6289e46d4f5391da37ce5af0ea7e");
        questionBean.setQuestionNum(2);
        questionBean.setType(1);
        List<QuestionItemBean> itemBeanList = new ArrayList<>();
        QuestionItemBean itemBean = new QuestionItemBean();
        itemBean.setId("fd2dfb7a06ca458aa535a5e663020bfd");
        itemBean.setUserOptionId("c24a2bd5dbfd4fdaa275c0ea6870b131");
        QuestionItemBean itemBean1 = new QuestionItemBean();
        itemBean1.setId("40ff171d77904ade8b2cfa4a5c6e88fe");
        itemBean1.setUserOptionId("40e6a57afb5d4c64b1d7c515c5eaadfb");
        itemBeanList.add(itemBean);
        itemBeanList.add(itemBean1);
        questionBean.setQuestionItemList(itemBeanList);
        questionReportBean.setQuestion(questionBean);
        this.mockMvc.perform(
                post("/v1/exercises/submit_paper").characterEncoding("UTF-8")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(questionReportBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }
    /**
     * 诊断报告
     */
    @Test
    public void getReport() throws  Exception{
        this.mockMvc.perform(
                get("/v1/exercises/reports/1cbeb5f0dd854f34b7c8d1c709603651?type=2")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
