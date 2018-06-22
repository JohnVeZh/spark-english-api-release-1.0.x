package cn.sparke.user.v1.address;

import cn.sparke.user.BaseTest;
import cn.sparke.user.modules.v1.address.bean.AddressBean;
import cn.sparke.user.modules.v1.favorities.bean.FavoriteBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class AddressTest extends BaseTest{
    /**
     * @Description: 新增地址
     */
    @Test
    public void save() throws Exception {
        AddressBean addressBean = new AddressBean();
        addressBean.setProvinceId("1");
        addressBean.setCityId("1");
        addressBean.setCountyId("1");
        addressBean.setDistrictCn("1");
        addressBean.setMobile("1");
        addressBean.setReceiver("1");
        addressBean.setZipcode("1");
        addressBean.setIsDefault(0);
        addressBean.setDetailAddress("1");
        this.mockMvc.perform(
                post("/v1/address").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .content(JSON.toJSONString(addressBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 更新
     */
    @Test
    public void update() throws Exception {
        AddressBean addressBean = new AddressBean();
        addressBean.setProvinceId("2");
        this.mockMvc.perform(
                put("/v1/address/c4b903902f4640f5ba9f1fedd3cfe865").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())
                        .content(JSON.toJSONString(addressBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 列表
     */
    @Test
    public void list() throws Exception {
        this.mockMvc.perform(
                get("/v1/address?start=0").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 删除
     */
    @Test
    public void deleteAdd() throws Exception {
        this.mockMvc.perform(
                delete("/v1/address/c4b903902f4640f5ba9f1fedd3cfe865").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
