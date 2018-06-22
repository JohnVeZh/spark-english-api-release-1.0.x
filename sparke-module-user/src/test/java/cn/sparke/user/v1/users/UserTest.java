package cn.sparke.user.v1.users;

import cn.sparke.user.BaseTest;
import cn.sparke.user.modules.v1.users.bean.*;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.DigestUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class UserTest extends BaseTest {
    /**
     * @Description: 测试用户登录
     */
    @Test
    public void login() throws Exception {
        LoginUserBean loginBean = new LoginUserBean();
        loginBean.setPhone("18764050615");
        loginBean.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        this.mockMvc.perform(
                post("/v1/login").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", getBaseHeader())
                        .content(JSON.toJSONString(loginBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 注册
     */
    @Test
    public void reg() throws Exception {
        UserRegBean userRegBean = new UserRegBean();
        userRegBean.setCode("1234");
        userRegBean.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        userRegBean.setPhone("18764050622");
        this.mockMvc.perform(
                post("/v1").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", getBaseHeader())
                        .content(JSON.toJSONString(userRegBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 忘记密码
     */
    @Test
    public void password_reset() throws Exception {
        ResetPwdBean resetPwdBean = new ResetPwdBean();
        resetPwdBean.setCode("1234");
        resetPwdBean.setPassword(DigestUtils.md5DigestAsHex("1234567".getBytes()));
        resetPwdBean.setPhone("18764050615");
        this.mockMvc.perform(
                put("/v1/password_reset").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(resetPwdBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 修改密码
     */
    @Test
    public void password_modify() throws Exception {
        ChangePwdBean changePwdBean = new ChangePwdBean();
        changePwdBean.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        changePwdBean.setOldPwd(DigestUtils.md5DigestAsHex("1234567".getBytes()));
        this.mockMvc.perform(
                put("/v1/password_modify").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION,getBaseHeader())
                        .content(JSON.toJSONString(changePwdBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 用户是否存在
     */
    @Test
    public void users() throws Exception {
        this.mockMvc.perform(
                get("/v1?phone=18764050615").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION,getBaseHeader())).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * @Description: 修改密码
     */
    @Test
    public void phone_modify() throws Exception {
        ChangePhoneBean changePhoneBean = new ChangePhoneBean();
        changePhoneBean.setOldPhone("18764050615");
        changePhoneBean.setOldSmsCode("1234");
        changePhoneBean.setPhone("18764050614");
        changePhoneBean.setSmsCode("1235");

        this.mockMvc.perform(
                put("/v1/phone_modify").characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION,getBaseHeader())
                        .content(JSON.toJSONString(changePhoneBean))).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
