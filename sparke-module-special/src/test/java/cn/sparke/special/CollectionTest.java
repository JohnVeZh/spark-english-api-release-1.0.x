package cn.sparke.special;

import cn.sparke.special.modules.v1.collection.bean.QuestionCollectionBean;
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
 * Created by Administrator on 2017/7/16.
 */
public class CollectionTest extends BaseTest {
    @Test
    /**
     * 新增收藏
     */
    public void addCollections() throws Exception{
        QuestionCollectionBean collectionBean = new QuestionCollectionBean();
        collectionBean.setContentType(1);
        collectionBean.setQuestionId("df87b9efd3ed11e68bac00163e4554dr");
        collectionBean.setStructureId("df87b9efd3ed11e68bac00163e4554f4");
        collectionBean.setQuestionItemId("df87b9efd3ed11e68bac00163e44e4dr");
        this.mockMvc.perform(
                post("/v1/collections").characterEncoding("UTF-8")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(collectionBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }
    @Test
    /**
     * 取消收藏
     */
    public void deletes() throws Exception {
        this.mockMvc.perform(
                delete("/v1/collections/3/df87b9efd3ed11e68bac00163e44e4dr")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }
    @Test
    /**
     * 收藏列表
     */
    public void getList() throws Exception {
        this.mockMvc.perform(
                get("/v1/collections?start=1&type=1")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }
    @Test
    /**
     * 收藏题目详情
     */
    public void getCollection() throws Exception {
        this.mockMvc.perform(
                get("/v1/collections/029caed3416b48c5805699f7ad2d76a1?type=2")
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
        ).andDo(print()).andExpect(status().is2xxSuccessful());

    }
}
