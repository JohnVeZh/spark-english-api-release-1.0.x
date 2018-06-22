package cn.sparke.special;

import cn.sparke.special.modules.v1.report.bean.ScoreBean;
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
 * Created by Administrator on 2017/7/19.
 */
public class ReportTest extends BaseTest {

    /**
     * 获取记录
     */
    @Test
    public void findRecordList() throws  Exception{
        this.mockMvc.perform(
                get("/v1/reports/records?start=1")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * 获取能力报告
     */
    @Test
    public void getAbility() throws  Exception{
        this.mockMvc.perform(
                get("/v1/reports/ability")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());
    }
    /**
     * 获取能力报告
     */
    @Test
    public void getWrongCollectionRecordNum() throws  Exception{
        this.mockMvc.perform(
                get("/v1/reports/wrong_collection_record_num")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * 获取能力报告详情
     */
    @Test
    public void getAbilityDetail() throws  Exception{
        List<ScoreBean> scoreBeanList = new ArrayList<>();
        for(int i = 1;i<= 5;i++){
            ScoreBean scoreBean = new ScoreBean();
            scoreBean.setScore(80);
            scoreBean.setType(i);
            scoreBeanList.add(scoreBean);
        }
        this.mockMvc.perform(
                post("/v1/reports/ability/detail").characterEncoding("UTF-8")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(scoreBeanList))).andDo(print()).andExpect(status().is2xxSuccessful());

    }
    /**
     * 诊断报告
     */
    @Test
    public void getReport() throws  Exception{
        this.mockMvc.perform(
                get("/v1/reports/df87b9efd3ed11e68bac00163e4554dr?type=2")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());
    }

}
