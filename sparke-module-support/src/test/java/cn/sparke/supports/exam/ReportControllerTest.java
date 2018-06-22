package cn.sparke.supports.exam;

import cn.sparke.core.modules.cache.CacheFacade;
import cn.sparke.core.modules.token.service.TokenService;
import cn.sparke.core.modules.token.utils.TokenUtils;
import cn.sparke.support.modules.v1.exam.bean.report.vo.ReportStructure;
import cn.sparke.support.modules.v1.exam.mapper.ReportMapper;
import cn.sparke.supports.BaseTest;
import org.apache.http.HttpHeaders;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/12 10:43
 */
public class ReportControllerTest extends BaseTest {
    @Autowired
    private TokenService tokenService;

    /**
     * 获取用户所有的记录
     */
    @Test
    public void double2int() throws Exception {


        double total = 2;
        double right = 1;
        double q = right / total;
        System.out.printf(q + "-------1111111111111111111111111111111111");
    }

    @Resource
    private ReportMapper reportMapper;

    @Test
    public void avg3() throws Exception {
        List<ReportStructure> reportStructureList = reportMapper.findReportByUserIdAndSectionCode("ac7ac530541645259476444d1127d149", 1);
        System.out.println("");
    }

    /**
     * 获取用户所有的记录
     */
    @Test
    public void avg2() throws Exception {
        this.mockMvc.perform(
                get("/v1/exam/composite_report").header(HttpHeaders.AUTHORIZATION, getdbHeader("8eb84194f15d48db97e9106d03e9f891")).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    /**
     * 获取用户所有的记录
     */
    @Test
    public void avg() throws Exception {
        this.mockMvc.perform(
                get("/v1/exam/composite_report").header(HttpHeaders.AUTHORIZATION, getdbHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     * 获取用户所有的记录
     */
    @Test
    public void wrong_books() throws Exception {
        this.mockMvc.perform(
                get("/v1/exam/reports?start=0").header(HttpHeaders.AUTHORIZATION, getdbHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     * 获取用户某个记录
     * <p>
     * {"total":3,"data":[{"id":"3b24311a1a3e47b3be4f9cfba6c2d710","paperName":"1"},{"id":"6082ea90fefe45679e7ed1750459b3c2","paperName":"1"},{"id":"9baa4e7c077c4810bad8772238f83886","paperName":"1"}]}
     */
    @Test
    public void get_reports() throws Exception {
        this.mockMvc.perform(
                get("/v1/exam/reports/a63eeb77576b49a58abccaba92f71451").header(HttpHeaders.AUTHORIZATION, getdbHeader("ae30a30046bd4d4da2808e9a950ab78b")).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }
}
