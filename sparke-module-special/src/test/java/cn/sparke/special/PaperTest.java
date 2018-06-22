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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Administrator on 2017/7/10.
 */
public class PaperTest extends BaseTest{
    @Test
    /**
     * 专项试卷
     */
    public void paperList() throws Exception {
        this.mockMvc.perform(
                get("/v1/papers")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }
    @Test
    /**
     * 试卷结构
     */
    public void structureList() throws  Exception{
        this.mockMvc.perform(
                get("/v1/papers/df87b9efd3ed11e68bac00163e0c8sd4/structure?contentType=1")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());
    }
    @Test
    public void submit() throws  Exception{
        QuestionReportBean questionReportBean = new QuestionReportBean();
        questionReportBean.setPaperId("df87b9efd3ed11e68bac00163e0c8sd4");
        questionReportBean.setPaperStructureId("df87b9efd3ed11e68bac00163e4554f4");
        questionReportBean.setUseTime(360);
        questionReportBean.setTotalNum(2);
        questionReportBean.setDidNum(2);
        questionReportBean.setNotDoneNum(0);
        QuestionBean questionBean = new QuestionBean();
        questionBean.setId("df87b9efd3ed11e68bac00163e4554dr");
        questionBean.setQuestionNum(2);
        questionBean.setType(1);
        List<QuestionItemBean> itemBeanList = new ArrayList<>();
        QuestionItemBean itemBean = new QuestionItemBean();
        itemBean.setId("df87b9efd3ed11e68bac00163e44e4dr");
        itemBean.setUserOptionId("df87b9efd3ed11e68bac00163e44e5dr");
        QuestionItemBean itemBean1 = new QuestionItemBean();
        itemBean1.setId("df87b9efd3ed11e68bac00163e4552dr");
        itemBean1.setUserOptionId("df87b9efd3ed11e68bac00163e4554gr");
        itemBeanList.add(itemBean);
        itemBeanList.add(itemBean1);
        questionBean.setQuestionItemList(itemBeanList);
        questionReportBean.setQuestion(questionBean);
        this.mockMvc.perform(
                post("/v1/papers/submit").characterEncoding("UTF-8")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(questionReportBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    @Test
    /**
     * 专项讲解列表
     */
    public void findExplainsList() throws  Exception{
        this.mockMvc.perform(
                get("/v1/papers/df87b9efd3ed11e68bac00163e0c8sd4/explains")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    @Test
    /**
     * 增加专项讲解访问量
     */
    public void addVisitNum() throws  Exception{
        this.mockMvc.perform(
                put("/v1/papers/explains/902880fd51468b56015147953f002sfr")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());
    }
//    @Test
//    /**
//     * 专项讲解详情
//     */
//    public void getExplain() throws  Exception{
//        this.mockMvc.perform(
//                get("/v1/papers/explains/902880fd51468b56015147953f002sfr")
//                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
//        ).andDo(print()).andExpect(status().is2xxSuccessful());
//    }
}
