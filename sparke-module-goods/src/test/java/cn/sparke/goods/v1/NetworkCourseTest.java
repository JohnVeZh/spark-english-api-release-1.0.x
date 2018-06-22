package cn.sparke.goods.v1;

import cn.sparke.BaseTest;
import cn.sparke.goods.modules.v1.networkCourse.bean.UserNetworkCourseBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by yangye on 2017/7/14.
 */
public class NetworkCourseTest extends BaseTest {

    public static final String URL_PREFIX = "/v1/network_courses";

    /**
     * @Description: 获取网课首页列表
     */
    @Test
    public void findList() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "/list?start=1&courseType=1").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 根据网课id查询网课详情
     */
    @Test
    public void getById() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "/d12adabd7c9147b1a77cb6d691900000").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 根据课程id，查询课程目录列表
     */
    @Test
    public void getCatalogsList() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "/catalogs/f2b7d7d655dd140b0155ddc46310000d").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 根据搜索id、搜索类型，查询视频列表
     */
    @Test
    public void getVideosList() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "/videos?searchType=2&searchId=8a987df758fbc3eb015900249f6d0002&deviceType=1").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 根据课程id查询教师列表
     */
    @Test
    public void getTeachersList() throws Exception {
        this.mockMvc.perform(get(URL_PREFIX + "/teachers/list/d12adabd7c9147b1a77cb6d691900000").header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 预约/领取网课
     */
    @Test
    public void obtainNetworkCourse() throws Exception {
        UserNetworkCourseBean uncBean = new UserNetworkCourseBean();
//        uncBean.setUserId("f30681ed39ee4c499f925574c40bebb9");
        uncBean.setNetworkCourseId("f2b7d7d655dd140b0155ddc46310000d");
        uncBean.setType(3);
        this.mockMvc.perform(post(URL_PREFIX + "/obtain").characterEncoding("UTF-8").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(uncBean))).andDo(print()).andExpect(status().is2xxSuccessful());

    }

}
