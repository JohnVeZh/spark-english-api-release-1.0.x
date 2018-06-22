package cn.sparke.special;

import cn.sparke.special.modules.v1.word.bean.WordUserReportBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Administrator on 2017/7/12.
 */
public class WordTest extends BaseTest {
    @Test
    /**
     * 获取单词二级目录
     */
    public void findTwoCatalogList() throws Exception {
        this.mockMvc.perform(
                get("/v1/words/catalogs?parentCatalogId=0101")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());
    }
    @Test
    /**
     * 获取单词三级目录
     */
    public void findThreeCatalogList() throws Exception {
        this.mockMvc.perform(
                get("/v1/words/catalogs/010102")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());
    }
    @Test
    /**
     * 获取单词详情
     */
    public void findWordList() throws Exception {
        this.mockMvc.perform(
                get("/v1/words?catalogId=df87b9efd3ed11e68bac00163e4554gr")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    @Test
    /**
     * 保存报告
     */
    public void inserReport() throws Exception {
        WordUserReportBean wordUserReportBean = new WordUserReportBean();
        wordUserReportBean.setRightNum(2);
        wordUserReportBean.setTotalNum(2);
        wordUserReportBean.setCatalogId("df87b9efd3ed11e68bac00163e4554gr");
        wordUserReportBean.setParentCatalogIds("df87b9efd3ed11e68bac00163e4554dr,df87b9efd3ed11e68bac00163e455edc");
        wordUserReportBean.setWrongNum(0);
        this.mockMvc.perform(
                post("/v1/words/reports").characterEncoding("UTF-8")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(wordUserReportBean))).andDo(print()).andExpect(status().is2xxSuccessful());

    }
    @Test
    /**
     * 加入错词本
     */
    public void addWrongBook() throws Exception {

        this.mockMvc.perform(
                post("/v1/words/wrongs/df87b9efd3ed11e68bac00163e45543r").characterEncoding("UTF-8")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }
    @Test
    /**
     * 移除错词本
     */
    public void removeWrongBook() throws Exception {

        this.mockMvc.perform(
                delete("/v1/words/wrongs/df87b9efd3ed11e68bac00163e45543r?type=1").characterEncoding("UTF-8")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }

}
