package cn.sparke.special;

import cn.sparke.special.modules.v1.question.bean.QuestionBean;
import cn.sparke.special.modules.v1.question.bean.QuestionItemBean;
import cn.sparke.special.modules.v1.report.bean.QuestionReportBean;
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
 * Created by Administrator on 2017/7/18.
 */
public class QuestionTest extends BaseTest{
    @Test
    /**
     * 题目列表
     */
    public void questionList() throws Exception {
        this.mockMvc.perform(
                get("/v1/questions?structureId=df87b9efd3ed11e68bac00163e4554f4")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }
    @Test
    /**
     * 题目详情
     */
    public void question() throws Exception {
        this.mockMvc.perform(
                get("/v1/questions/af2185adab6a402dbb20a8179e318470?type=1")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }
    /**
     * 做题
     */
    @Test
    public void quit() throws  Exception{
        QuestionReportBean questionReportBean = new QuestionReportBean();
        questionReportBean.setPaperId("df87b9efd3ed11e68bac00163e0c8sd4");
        questionReportBean.setPaperType(1);
        questionReportBean.setPaperStructureId("df87b9efd3ed11e68bac00163e4554f4");
        questionReportBean.setUseTime(360);
        questionReportBean.setTotalNum(2);
        questionReportBean.setDidNum(2);
        questionReportBean.setNotDoneNum(0);
        QuestionBean questionBean = new QuestionBean();
        questionBean.setId("df87b9efd3ed11e68bac00163e4554dr");
        questionBean.setQuestionNum(2);
        List<QuestionItemBean> itemBeanList = new ArrayList<>();
        QuestionItemBean itemBean = new QuestionItemBean();
        itemBean.setId("df87b9efd3ed11e68bac00163e44e4dr");
        itemBean.setUserOptionId("df87b9efd3ed11e68bac00163e44e5dr");
        itemBeanList.add(itemBean);
        questionBean.setQuestionItemList(itemBeanList);
        questionReportBean.setQuestion(questionBean);
        this.mockMvc.perform(
                post("/v1/questions/quit").characterEncoding("UTF-8")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(questionReportBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }
    /**
     * 做题
     */
    @Test
    public void submmit() throws  Exception{
        QuestionReportBean translationReportBean = new QuestionReportBean();
        translationReportBean.setPaperType(3);
        translationReportBean.setPaperId("df87b9efd3ed11e68bac00163r5c8sf4");
        translationReportBean.setPaperStructureId("df87b9efd3ed11e68bac00163r5crdgb");
        QuestionBean questionBean = new QuestionBean();
        questionBean.setId("df87b9efd3ed11e68bac00163e422345");
        questionBean.setQuestionNum(1);
        questionBean.setDifficultyLevel(1);
        translationReportBean.setQuestion(questionBean);

        this.mockMvc.perform(
                post("/v1/questions/submit").characterEncoding("UTF-8")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(translationReportBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
