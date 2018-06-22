package cn.sparke.supports.exam;

import cn.sparke.support.modules.v1.exam.bean.submit.vo.request.SubmitPaper;
import cn.sparke.support.modules.v1.exam.bean.submit.vo.request.SubmitQuestionItem;
import cn.sparke.support.modules.v1.exam.bean.submit.vo.request.SubmitQuestionSubItem;
import cn.sparke.support.modules.v1.exam.service.ExamService;
import cn.sparke.supports.BaseTest;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHeaders;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ExamControllerTest extends BaseTest {
    /**
     */
    @Test
    public void caption_hearing() throws Exception {
        this.mockMvc.perform(
                get("/v1/exam/catalog/papers").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    /**
     */
    @Test
    public void download() throws Exception {
        this.mockMvc.perform(
                get("/v1/exam/papers/f2b785da5cf2fe21015d1ab8f7030006/download").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }

    @Resource
    private ExamService examService;

    @Test
    public void submitJson12() throws Exception {
        String jsonStr = "{\n" +
                "\t\"didNum\": \"6\",\n" +
                "\t\"totalNum\": \"6\",\n" +
                "\t\"useTime\": \"20\",\n" +
                "\t\"paperId\": \"f2b7d7d655c458ec0155c459dac10001\",\n" +
                "\t\"paperType\": 1,\n" +
                "\t\"paperStructureId\": \"22924a92999911e793086c92bf20e479\",\n" +
                "\t\"questionList\": [{\n" +
                "\t\t\"id\": \"f2b7d7d655c458ec0155c459dad10002\",\n" +
                "\t\t\"questionItemList\": [{\n" +
                "\t\t\t\"id\": \"f2b7d7d655c458ec0155c459daf00004\",\n" +
                "\t\t\t\"userOptionId\": \"f2b7d7d655c458ec0155c459daf00005\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"id\": \"f2b7d7d655c458ec0155c459db1f0009\",\n" +
                "\t\t\t\"userOptionId\": \"f2b7d7d655c458ec0155c459db2f000b\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"id\": \"f2b7d7d655c458ec0155c459db4e000e\",\n" +
                "\t\t\t\"userOptionId\": \"f2b7d7d655c458ec0155c459db6d0010\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"id\": \"f2b7d7d655c458ec0155c459db8c0013\",\n" +
                "\t\t\t\"userOptionId\": \"f2b7d7d655c458ec0155c459db9c0015\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"id\": \"f2b7d7d655c458ec0155c459dbcb0018\",\n" +
                "\t\t\t\"userOptionId\": \"f2b7d7d655c458ec0155c459dbea001b\"\n" +
                "\t\t}],\n" +
                "\t\t\"structureAlias\": \"新闻听力\",\n" +
                "\t\t\"isFinish\": 1,\n" +
                "\t\t\"structureId\": \"22924a92999911e793086c92bf20e479\"\n" +
                "\t}, {\n" +
                "\t\t\"id\": \"f2b7d7d655c458ec0155c459dc670027\",\n" +
                "\t\t\"questionItemList\": [{\n" +
                "\t\t\t\"id\": \"f2b7d7d655c458ec0155c459dcb5002e\",\n" +
                "\t\t\t\"userOptionId\": \"f2b7d7d655c458ec0155c459dcc50030\"\n" +
                "\t\t}],\n" +
                "\t\t\"structureAlias\": \"长对话\",\n" +
                "\t\t\"isFinish\": 1,\n" +
                "\t\t\"structureId\": \"2292d49a999911e793086c92bf20e479\"\n" +
                "\t}],\n" +
                "\t\"notDoneNum\": \"0\"\n" +
                "}\n" +
                "\n" +
                "\n";
        SubmitPaper submitPaper = JSON.parseObject(jsonStr,SubmitPaper.class);
        examService.submitPaper(submitPaper);
      }
    @Test
    public void submitJson() throws Exception {
       String jsonStr = "{\"paperId\":\"57314de0c22988c8153a9efa\",\"paperStructureId\":\"24db6157999911e793086c92bf20e479\",\"paperType\":1,\"didNum\":\"12\",\"useTime\":\"20\",\"totalNum\":\"12\",\"notDoneNum\":\"0\",\"questionList\":[{\"id\":\"57314de0c22988c8153a9eb8\",\"structureId\":\"24db6157999911e793086c92bf20e479\",\"structureAlias\":\"新闻听力\",\"isFinish\":1,\"questionItemList\":[{\"id\":\"57314de0c22988c8153a9eb6\",\"userOptionId\":\"0.7629407036704390.4052642373417\"},{\"id\":\"57314de0c22988c8153a9eb7\",\"userOptionId\":\"0.32808518626548830.819483484904\"}]},{\"id\":\"57314de0c22988c8153a9ebb\",\"structureId\":\"24db6157999911e793086c92bf20e479\",\"structureAlias\":\"新闻听力\",\"isFinish\":1,\"questionItemList\":[{\"id\":\"57314de0c22988c8153a9eb9\",\"userOptionId\":\"0.351603851049769540.88162474323\"}]},{\"id\":\"57314de0c22988c8153a9ebf\",\"structureId\":\"24db6157999911e793086c92bf20e479\",\"structureAlias\":\"新闻听力\",\"isFinish\":1,\"questionItemList\":[{\"id\":\"57314de0c22988c8153a9ebd\",\"userOptionId\":\"0.221035081167738040.40357043166\"},{\"id\":\"57314de0c22988c8153a9ebe\",\"userOptionId\":\"0.30170077392989840.031730564340\"}]},{\"id\":\"57314de0c22988c8153a9ec4\",\"structureId\":\"24dc9721999911e793086c92bf20e479\",\"structureAlias\":\"长对话\",\"isFinish\":1,\"questionItemList\":[{\"id\":\"57314de0c22988c8153a9ec0\",\"userOptionId\":\"0.262270650139330540.15332846078\"},{\"id\":\"57314de0c22988c8153a9ec1\",\"userOptionId\":\"0.406250959640602540.67145064163\"},{\"id\":\"57314de0c22988c8153a9ec3\",\"userOptionId\":\"0.0034615444051674980.4719873885\"}]},{\"id\":\"57314de0c22988c8153a9ec9\",\"structureId\":\"24dc9721999911e793086c92bf20e479\",\"structureAlias\":\"长对话\",\"isFinish\":1,\"questionItemList\":[{\"id\":\"57314de0c22988c8153a9ec5\",\"userOptionId\":\"0.28397911720348440.668133403796\"},{\"id\":\"57314de0c22988c8153a9ec6\",\"userOptionId\":\"0.40951098353556450.924704884108\"},{\"id\":\"57314de0c22988c8153a9ec7\",\"userOptionId\":\"0.195617596801014230.61912423988\"},{\"id\":\"57314de0c22988c8153a9ec8\",\"userOptionId\":\"0.310027859462451040.90823225668\"}]}]}";
        // String jsonStr = "{\"didNum\":\"25\",\"notDoneNum\":\"0\",\"paperId\":\"f2b785da5cf2fe21015d1ab879760003\",\"paperStructureId\":\"2ddaa5da91cb11e793086c92bf20e479\",\"paperType\":\"1\",\"questionList\":[{\"id\":\"f2b785da5cf2fe21015d1b29da36022c\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"f2b785da5cf2fe21015d1b2d3412022e\",\"userOptionId\":\"f2b785da5cf2fe21015d1b2d3421022f\"},{\"id\":\"f2b785da5cf2fe21015d1b877dfd0260\",\"userOptionId\":\"f2b785da5cf2fe21015d1b8cd5c00268\"},{\"id\":\"f2b785da5cf2fe21015d1b8a883a0262\",\"userOptionId\":\"f2b785da5cf2fe21015d1b8e81a8026c\"},{\"id\":\"f2b785da5cf2fe21015d1b8bdf1d0263\",\"userOptionId\":\"f2b785da5cf2fe21015d1b8bdf2d0264\"},{\"id\":\"f2b785da5cf2fe21015d1b9760e70271\",\"userOptionId\":\"f2b785da5cf2fe21015d1b9760f60272\"},{\"id\":\"f2b785da5cf2fe21015d1b9848570276\",\"userOptionId\":\"f2b785da5cf2fe21015d1b9848680277\"},{\"id\":\"f2b785da5cf2fe21015d1b995253027b\",\"userOptionId\":\"f2b785da5cf2fe21015d1b995263027c\"}],\"structureAlias\":\"新闻听力\",\"structureId\":\"2ddb661991cb11e793086c92bf20e479\"},{\"id\":\"f2b785da5cf2fe21015d1b9b64670280\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"f2b785da5cf2fe21015d1b9dafab0282\",\"userOptionId\":\"f2b785da5cf2fe21015d1b9dafba0283\"},{\"id\":\"f2b785da5cf2fe21015d1b9f5ae70287\",\"userOptionId\":\"f2b785da5cf2fe21015d1b9f5ae70288\"},{\"id\":\"f2b785da5cf2fe21015d1ba07658028c\",\"userOptionId\":\"f2b785da5cf2fe21015d1ba07667028d\"},{\"id\":\"f2b785da5cf2fe21015d1ba1fc880291\",\"userOptionId\":\"f2b785da5cf2fe21015d1ba1fc970292\"},{\"id\":\"f2b785da5cf2fe21015d1ba3e3a40297\",\"userOptionId\":\"f2b785da5cf2fe21015d1ba3e3e20298\"},{\"id\":\"f2b785da5cf2fe21015d1ba5968102a6\",\"userOptionId\":\"f2b785da5cf2fe21015d1ba5968102a7\"},{\"id\":\"f2b785da5cf2fe21015d1ba7b3ef02b0\",\"userOptionId\":\"f2b785da5cf2fe21015d1ba7b3ff02b1\"},{\"id\":\"f2b785da5cf2fe21015d1ba92dbb02ba\",\"userOptionId\":\"f2b785da5cf2fe21015d1ba92dbb02bb\"}],\"structureAlias\":\"长对话\",\"structureId\":\"2ddbf70f91cb11e793086c92bf20e479\"},{\"id\":\"f2b785da5cf2fe21015d1babcd5802c9\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"f2b785da5cf2fe21015d1baea2da02da\",\"userOptionId\":\"f2b785da5cf2fe21015d1baea2ea02db\"},{\"id\":\"f2b785da5cf2fe21015d1baf91fb02e4\",\"userOptionId\":\"f2b785da5cf2fe21015d1baf91fb02e5\"},{\"id\":\"f2b785da5cf2fe21015d1bb1a5b502e9\",\"userOptionId\":\"f2b785da5cf2fe21015d1bb1a5b502ea\"},{\"id\":\"f2b785da5cf2fe21015d1bb3ecc302ef\",\"userOptionId\":\"f2b785da5cf2fe21015d1bb3ecd202f0\"},{\"id\":\"f2b785da5cf2fe21015d1bb4e18102f4\",\"userOptionId\":\"f2b785da5cf2fe21015d1bb4e18102f5\"},{\"id\":\"f2b785da5cf2fe21015d1bb5e32102f9\",\"userOptionId\":\"f2b785da5cf2fe21015d1bb5e32102fa\"},{\"id\":\"f2b785da5cf2fe21015d1bb808fb030f\",\"userOptionId\":\"f2b785da5cf2fe21015d1bb8090a0310\"},{\"id\":\"f2b785da5cf2fe21015d1bba59300314\",\"userOptionId\":\"f2b785da5cf2fe21015d1bba594f0315\"},{\"id\":\"f2b785da5cf2fe21015d1bbbbf460329\",\"userOptionId\":\"f2b785da5cf2fe21015d1bbbbf46032a\"},{\"id\":\"f2b785da5cf2fe21015d1bbc9ea9032e\",\"userOptionId\":\"f2b785da5cf2fe21015d1bbc9eb80331\"}],\"structureAlias\":\"短文理解\",\"structureId\":\"2ddc7c6691cb11e793086c92bf20e479\"}],\"totalNum\":\"25\",\"useTime\":\"0\"}";
      //String jsonStr = "{\"didNum\":\"25\",\"notDoneNum\":\"0\",\"paperId\":\"57314de0c22988c8153a9f86\",\"paperStructureId\":\"25ec2bb991cb11e793086c92bf20e479\",\"paperType\":\"1\",\"questionList\":[{\"id\":\"57314de0c22988c8153a9f44\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314de0c22988c8153a9f42\",\"userOptionId\":\"0.94626958104434390.142643989196\"},{\"id\":\"57314de0c22988c8153a9f43\",\"userOptionId\":\"0.314060409845840550.51299998305\"}]},{\"id\":\"57314de0c22988c8153a9f47\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314de0c22988c8153a9f45\",\"userOptionId\":\"0.73149333682981630.137067978398\"},{\"id\":\"57314de0c22988c8153a9f46\",\"userOptionId\":\"0.71528548534520490.146339973571\"}]},{\"id\":\"57314de0c22988c8153a9f4b\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314de0c22988c8153a9f48\",\"userOptionId\":\"0.381947446970220150.32049596339\"},{\"id\":\"57314de0c22988c8153a9f49\",\"userOptionId\":\"0.76388080954913130.163459926995\"},{\"id\":\"57314de0c22988c8153a9f4a\",\"userOptionId\":\"0.67356173756864080.855811775527\"}]},{\"id\":\"57314de0c22988c8153a9f50\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314de0c22988c8153a9f4c\",\"userOptionId\":\"0.076166289929455410.78867912738\"},{\"id\":\"57314de0c22988c8153a9f4d\",\"userOptionId\":\"0.36014626767499960.375960341073\"},{\"id\":\"57314de0c22988c8153a9f4e\",\"userOptionId\":\"0.57223249932027650.513764353947\"},{\"id\":\"57314de0c22988c8153a9f4f\",\"userOptionId\":\"0.7807237243100290.4409407772505\"}]},{\"id\":\"57314de0c22988c8153a9f55\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314de0c22988c8153a9f51\",\"userOptionId\":\"0.186921154322960550.66341085514\"},{\"id\":\"57314de0c22988c8153a9f52\",\"userOptionId\":\"0.59243462941836070.994231974700\"},{\"id\":\"57314de0c22988c8153a9f53\",\"userOptionId\":\"0.401409714856566570.98092733880\"},{\"id\":\"57314de0c22988c8153a9f54\",\"userOptionId\":\"0.2297447167613960.9219408006611\"}]},{\"id\":\"57314de0c22988c8153a9f59\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314de0c22988c8153a9f56\",\"userOptionId\":\"0.94449446997092520.666922017621\"},{\"id\":\"57314de0c22988c8153a9f57\",\"userOptionId\":\"0.033238230304083070.56878771685\"},{\"id\":\"57314de0c22988c8153a9f58\",\"userOptionId\":\"0.33270777234128470.843172562162\"}]},{\"id\":\"57314de0c22988c8153a9f5e\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314de0c22988c8153a9f5a\",\"userOptionId\":\"0.56382420152781920.509499690969\"},{\"id\":\"57314de0c22988c8153a9f5b\",\"userOptionId\":\"0.8209977213488870.0179807990956\"},{\"id\":\"57314de0c22988c8153a9f5c\",\"userOptionId\":\"0.41351603289462260.561404953302\"},{\"id\":\"57314de0c22988c8153a9f5d\",\"userOptionId\":\"0.60458703116009670.753082399957\"}]},{\"id\":\"57314de0c22988c8153a9f62\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314de0c22988c8153a9f5f\",\"userOptionId\":\"0.78238708785026070.081197170616\"},{\"id\":\"57314de0c22988c8153a9f60\",\"userOptionId\":\"0.098174376504658140.14673868394\"},{\"id\":\"57314de0c22988c8153a9f61\",\"userOptionId\":\"0.14371064970615380.490101938592\"}]}],\"totalNum\":\"25\",\"useTime\":\"0\"}";
        //  String jsonStr = "{\"didNum\":\"1\",\"notDoneNum\":\"24\",\"paperId\":\"57314ddfc22988c8153a9e6e\",\"paperStructureId\":\"513417538d2811e7b07e6c92bf2c1455\",\"paperType\":\"1\",\"questionList\":[{\"id\":\"57314ddfc22988c8153a9e2c\",\"isFinish\":\"0\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e2a\",\"userOptionId\":\"0.4760508979447660.6525653169048\"},{\"id\":\"57314ddfc22988c8153a9e2b\"}],\"structureAlias\":\"新闻听力\",\"structureId\":\"50edc3ad8d2811e7b07e6c92bf2c1455\"},{\"id\":\"57314ddfc22988c8153a9e2f\",\"isFinish\":\"0\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e2d\"},{\"id\":\"57314ddfc22988c8153a9e2e\"}],\"structureAlias\":\"新闻听力\",\"structureId\":\"50edc3ad8d2811e7b07e6c92bf2c1455\"},{\"id\":\"57314ddfc22988c8153a9e33\",\"isFinish\":\"0\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e30\"},{\"id\":\"57314ddfc22988c8153a9e31\"},{\"id\":\"57314ddfc22988c8153a9e32\"}],\"structureAlias\":\"新闻听力\",\"structureId\":\"50edc3ad8d2811e7b07e6c92bf2c1455\"},{\"id\":\"57314ddfc22988c8153a9e38\",\"isFinish\":\"0\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e34\"},{\"id\":\"57314ddfc22988c8153a9e35\"},{\"id\":\"57314ddfc22988c8153a9e36\"},{\"id\":\"57314ddfc22988c8153a9e37\"}],\"structureAlias\":\"长对话\",\"structureId\":\"50eec5928d2811e7b07e6c92bf2c1455\"},{\"id\":\"57314ddfc22988c8153a9e3d\",\"isFinish\":\"0\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e39\"},{\"id\":\"57314ddfc22988c8153a9e3a\"},{\"id\":\"57314ddfc22988c8153a9e3b\"},{\"id\":\"57314ddfc22988c8153a9e3c\"}],\"structureAlias\":\"长对话\",\"structureId\":\"50eec5928d2811e7b07e6c92bf2c1455\"},{\"id\":\"57314ddfc22988c8153a9e41\",\"isFinish\":\"0\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e3e\"},{\"id\":\"57314ddfc22988c8153a9e3f\"},{\"id\":\"57314ddfc22988c8153a9e40\"}],\"structureAlias\":\"短文理解\",\"structureId\":\"50ef80b08d2811e7b07e6c92bf2c1455\"},{\"id\":\"57314ddfc22988c8153a9e46\",\"isFinish\":\"0\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e42\"},{\"id\":\"57314ddfc22988c8153a9e43\"},{\"id\":\"57314ddfc22988c8153a9e44\"},{\"id\":\"57314ddfc22988c8153a9e45\"}],\"structureAlias\":\"短文理解\",\"structureId\":\"50ef80b08d2811e7b07e6c92bf2c1455\"},{\"id\":\"57314ddfc22988c8153a9e4a\",\"isFinish\":\"0\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e47\"},{\"id\":\"57314ddfc22988c8153a9e48\"},{\"id\":\"57314ddfc22988c8153a9e49\"}],\"structureAlias\":\"短文理解\",\"structureId\":\"50ef80b08d2811e7b07e6c92bf2c1455\"}],\"totalNum\":\"25\",\"useTime\":\"25\"}";
        //String jsonStr = "{\"didNum\":\"25\",\"notDoneNum\":\"0\",\"paperId\":\"57314ddfc22988c8153a9e6e\",\"paperStructureId\":\"97a41c947ef611e7856300163e0e8110\",\"paperType\":\"1\",\"questionList\":[{\"id\":\"57314ddfc22988c8153a9e2c\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e2a\",\"userOptionId\":\"0.79783184248752140.309095250730\"},{\"id\":\"57314ddfc22988c8153a9e2b\",\"userOptionId\":\"0.55620081029478540.890189984711\"}],\"structureAlias\":\"新闻听力\",\"structureId\":\"97a1486a7ef611e7856300163e0e8110\"},{\"id\":\"57314ddfc22988c8153a9e2f\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e2d\",\"userOptionId\":\"0.387508554745007840.52366420209\"},{\"id\":\"57314ddfc22988c8153a9e2e\",\"userOptionId\":\"0.268940373574328040.94775108708\"}],\"structureAlias\":\"新闻听力\",\"structureId\":\"97a1486a7ef611e7856300163e0e8110\"},{\"id\":\"57314ddfc22988c8153a9e33\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e30\",\"userOptionId\":\"0.182176234370261650.16776285988\"},{\"id\":\"57314ddfc22988c8153a9e31\",\"userOptionId\":\"0.104060081861969160.99556106887\"},{\"id\":\"57314ddfc22988c8153a9e32\",\"userOptionId\":\"0.97377173693270580.474516795458\"}],\"structureAlias\":\"新闻听力\",\"structureId\":\"97a1486a7ef611e7856300163e0e8110\"},{\"id\":\"57314ddfc22988c8153a9e38\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e34\",\"userOptionId\":\"0.55667846981126670.385900801407\"},{\"id\":\"57314ddfc22988c8153a9e35\",\"userOptionId\":\"0.8620771689918610.5059536513927\"},{\"id\":\"57314ddfc22988c8153a9e36\",\"userOptionId\":\"0.64035046625915030.372065883476\"},{\"id\":\"57314ddfc22988c8153a9e37\",\"userOptionId\":\"0.6155208550538130.3424684939370\"}],\"structureAlias\":\"长对话\",\"structureId\":\"97a17c207ef611e7856300163e0e8110\"},{\"id\":\"57314ddfc22988c8153a9e3d\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e39\",\"userOptionId\":\"0.15655290722525950.596144849989\"},{\"id\":\"57314ddfc22988c8153a9e3a\",\"userOptionId\":\"0.93620200169850330.953318798871\"},{\"id\":\"57314ddfc22988c8153a9e3b\",\"userOptionId\":\"0.211351317550382860.97815947511\"},{\"id\":\"57314ddfc22988c8153a9e3c\",\"userOptionId\":\"0.248150613390049540.03084100972\"}],\"structureAlias\":\"长对话\",\"structureId\":\"97a17c207ef611e7856300163e0e8110\"},{\"id\":\"57314ddfc22988c8153a9e41\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e3e\",\"userOptionId\":\"0.6066991450327440.2197266539742\"},{\"id\":\"57314ddfc22988c8153a9e3f\",\"userOptionId\":\"0.289043915727216660.00611027144\"},{\"id\":\"57314ddfc22988c8153a9e40\",\"userOptionId\":\"0.62512217427149620.371371426034\"}],\"structureAlias\":\"短文理解\",\"structureId\":\"97a19d377ef611e7856300163e0e8110\"},{\"id\":\"57314ddfc22988c8153a9e46\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e42\",\"userOptionId\":\"0.25847915490947590.838526346570\"},{\"id\":\"57314ddfc22988c8153a9e43\",\"userOptionId\":\"0.41702928246653570.078517485483\"},{\"id\":\"57314ddfc22988c8153a9e44\",\"userOptionId\":\"0.3097089783378960.8770084184380\"},{\"id\":\"57314ddfc22988c8153a9e45\",\"userOptionId\":\"0.297457075023518040.14948966647\"}],\"structureAlias\":\"短文理解\",\"structureId\":\"97a19d377ef611e7856300163e0e8110\"},{\"id\":\"57314ddfc22988c8153a9e4a\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e47\",\"userOptionId\":\"0.5581584708375470.1164231077920\"},{\"id\":\"57314ddfc22988c8153a9e48\",\"userOptionId\":\"0.89842115985082570.133646570270\"},{\"id\":\"57314ddfc22988c8153a9e49\",\"userOptionId\":\"0.81763041747513270.318963558710\"}],\"structureAlias\":\"短文理解\",\"structureId\":\"97a19d377ef611e7856300163e0e8110\"}],\"totalNum\":\"25\",\"useTime\":\"0\"}";
        this.mockMvc.perform(
                post("/v1/exam/papers/submit")
                        .header(HttpHeaders.AUTHORIZATION, getdbHeader("8a9b87c05cb10f3e015cce4f563e4b4b"))
                        .content(jsonStr)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status()
                        .is2xxSuccessful());

        String json = "{\"didNum\":\"25\",\"notDoneNum\":\"0\",\"paperId\":\"57314ddfc22988c8153a9e6e\",\"paperStructureId\":\"513417538d2811e7b07e6c92bf2c1455\",\"paperType\":\"1\",\"questionList\":[{\"id\":\"57314ddfc22988c8153a9e2c\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e2a\",\"userOptionId\":\"0.4760508979447660.6525653169048\"},{\"id\":\"57314ddfc22988c8153a9e2b\",\"userOptionId\":\"0.4821940702220370.3199336224421\"}],\"structureAlias\":\"新闻听力\",\"structureId\":\"50edc3ad8d2811e7b07e6c92bf2c1455\"},{\"id\":\"57314ddfc22988c8153a9e2f\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e2d\",\"userOptionId\":\"0.98281768800953180.641972192229\"},{\"id\":\"57314ddfc22988c8153a9e2e\",\"userOptionId\":\"0.46750626011519350.250060124555\"}],\"structureAlias\":\"新闻听力\",\"structureId\":\"50edc3ad8d2811e7b07e6c92bf2c1455\"},{\"id\":\"57314ddfc22988c8153a9e33\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e30\",\"userOptionId\":\"0.38907826728101660.324384076822\"},{\"id\":\"57314ddfc22988c8153a9e31\",\"userOptionId\":\"0.54287258679314750.871740041181\"},{\"id\":\"57314ddfc22988c8153a9e32\",\"userOptionId\":\"0.54712816285633310.385548006170\"}],\"structureAlias\":\"新闻听力\",\"structureId\":\"50edc3ad8d2811e7b07e6c92bf2c1455\"},{\"id\":\"57314ddfc22988c8153a9e38\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e34\",\"userOptionId\":\"0.107023084635867820.31251993804\"},{\"id\":\"57314ddfc22988c8153a9e35\",\"userOptionId\":\"0.89373096534398480.405955702444\"},{\"id\":\"57314ddfc22988c8153a9e36\",\"userOptionId\":\"0.147585603545965250.09221872882\"},{\"id\":\"57314ddfc22988c8153a9e37\",\"userOptionId\":\"0.056735152431517050.24322656750\"}],\"structureAlias\":\"长对话\",\"structureId\":\"50eec5928d2811e7b07e6c92bf2c1455\"},{\"id\":\"57314ddfc22988c8153a9e3d\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e39\",\"userOptionId\":\"0.84091898225333450.939476681816\"},{\"id\":\"57314ddfc22988c8153a9e3a\",\"userOptionId\":\"0.0343894847057661860.9677037372\"},{\"id\":\"57314ddfc22988c8153a9e3b\",\"userOptionId\":\"0.64919050750247250.020088671725\"},{\"id\":\"57314ddfc22988c8153a9e3c\",\"userOptionId\":\"0.142784114128708950.19733217749\"}],\"structureAlias\":\"长对话\",\"structureId\":\"50eec5928d2811e7b07e6c92bf2c1455\"},{\"id\":\"57314ddfc22988c8153a9e41\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e3e\",\"userOptionId\":\"0.76634907886977220.926394903032\"},{\"id\":\"57314ddfc22988c8153a9e3f\",\"userOptionId\":\"0.403393082696379250.03997801341\"},{\"id\":\"57314ddfc22988c8153a9e40\",\"userOptionId\":\"0.71791820760622450.420705388691\"}],\"structureAlias\":\"短文理解\",\"structureId\":\"50ef80b08d2811e7b07e6c92bf2c1455\"},{\"id\":\"57314ddfc22988c8153a9e46\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e42\",\"userOptionId\":\"0.379411820675629950.98359293395\"},{\"id\":\"57314ddfc22988c8153a9e43\",\"userOptionId\":\"0.74330451129312110.655848534457\"},{\"id\":\"57314ddfc22988c8153a9e44\",\"userOptionId\":\"0.57828712517236090.328463901140\"},{\"id\":\"57314ddfc22988c8153a9e45\",\"userOptionId\":\"0.66152212271608610.674773933063\"}],\"structureAlias\":\"短文理解\",\"structureId\":\"50ef80b08d2811e7b07e6c92bf2c1455\"},{\"id\":\"57314ddfc22988c8153a9e4a\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e47\",\"userOptionId\":\"0.57274926879699270.388477992628\"},{\"id\":\"57314ddfc22988c8153a9e48\",\"userOptionId\":\"0.87918000657035030.918068194685\"},{\"id\":\"57314ddfc22988c8153a9e49\",\"userOptionId\":\"0.67765225719441870.424907026276\"}],\"structureAlias\":\"短文理解\",\"structureId\":\"50ef80b08d2811e7b07e6c92bf2c1455\"}],\"totalNum\":\"25\",\"useTime\":\"20\"}";
    }

    @Test
    public void submitJson3()throws Exception {
        String json  = "{\"didNum\":\"25\",\"notDoneNum\":\"0\",\"paperId\":\"57314ddfc22988c8153a9e6e\",\"paperStructureId\":\"65e5e5b2913011e793086c92bf20e479\",\"paperType\":\"1\",\"questionList\":[{\"id\":\"57314ddfc22988c8153a9e2c\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e2a\",\"userOptionId\":\"0.72658688922094830.919881543069\"},{\"id\":\"57314ddfc22988c8153a9e2b\",\"userOptionId\":\"0.74807273293665870.966502435474\"}],\"structureAlias\":\"新闻听力\",\"structureId\":\"a96361c18fb211e793086c92bf20e479\"},{\"id\":\"57314ddfc22988c8153a9e2f\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e2d\",\"userOptionId\":\"0.66928364771351560.840940083228\"},{\"id\":\"57314ddfc22988c8153a9e2e\",\"userOptionId\":\"0.268940373574328040.94775108708\"}],\"structureAlias\":\"新闻听力\",\"structureId\":\"a96412178fb211e793086c92bf20e479\"},{\"id\":\"57314ddfc22988c8153a9e33\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e30\",\"userOptionId\":\"0.38907826728101660.324384076822\"},{\"id\":\"57314ddfc22988c8153a9e31\",\"userOptionId\":\"0.54287258679314750.871740041181\"},{\"id\":\"57314ddfc22988c8153a9e32\",\"userOptionId\":\"0.65922852387579960.603553755770\"}],\"structureAlias\":\"新闻听力\",\"structureId\":\"a964faa78fb211e793086c92bf20e479\"},{\"id\":\"57314ddfc22988c8153a9e38\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e34\",\"userOptionId\":\"0.55667846981126670.385900801407\"},{\"id\":\"57314ddfc22988c8153a9e35\",\"userOptionId\":\"0.89373096534398480.405955702444\"},{\"id\":\"57314ddfc22988c8153a9e36\",\"userOptionId\":\"0.64035046625915030.372065883476\"},{\"id\":\"57314ddfc22988c8153a9e37\",\"userOptionId\":\"0.66268698094662930.180404605511\"}],\"structureAlias\":\"长对话\",\"structureId\":\"a9658fdd8fb211e793086c92bf20e479\"},{\"id\":\"57314ddfc22988c8153a9e3d\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e39\",\"userOptionId\":\"0.5541207572017990.0199751220829\"},{\"id\":\"57314ddfc22988c8153a9e3a\",\"userOptionId\":\"0.78254287390275190.558661824612\"},{\"id\":\"57314ddfc22988c8153a9e3b\",\"userOptionId\":\"0.294809558703386760.86871460161\"},{\"id\":\"57314ddfc22988c8153a9e3c\",\"userOptionId\":\"0.462631839758373630.75908949948\"}],\"structureAlias\":\"长对话\",\"structureId\":\"a967b50a8fb211e793086c92bf20e479\"},{\"id\":\"57314ddfc22988c8153a9e41\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e3e\",\"userOptionId\":\"0.76634907886977220.926394903032\"},{\"id\":\"57314ddfc22988c8153a9e3f\",\"userOptionId\":\"0.403393082696379250.03997801341\"},{\"id\":\"57314ddfc22988c8153a9e40\",\"userOptionId\":\"0.62512217427149620.371371426034\"}],\"structureAlias\":\"短文理解\",\"structureId\":\"a96841ee8fb211e793086c92bf20e479\"},{\"id\":\"57314ddfc22988c8153a9e46\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e42\",\"userOptionId\":\"0.379411820675629950.98359293395\"},{\"id\":\"57314ddfc22988c8153a9e43\",\"userOptionId\":\"0.50072579598121880.084719272409\"},{\"id\":\"57314ddfc22988c8153a9e44\",\"userOptionId\":\"0.57828712517236090.328463901140\"},{\"id\":\"57314ddfc22988c8153a9e45\",\"userOptionId\":\"0.3932146610628950.8219565402920\"}],\"structureAlias\":\"短文理解\",\"structureId\":\"a968bf968fb211e793086c92bf20e479\"},{\"id\":\"57314ddfc22988c8153a9e4a\",\"isFinish\":\"1\",\"questionItemList\":[{\"id\":\"57314ddfc22988c8153a9e47\",\"userOptionId\":\"0.57274926879699270.388477992628\"},{\"id\":\"57314ddfc22988c8153a9e48\",\"userOptionId\":\"0.87918000657035030.918068194685\"},{\"id\":\"57314ddfc22988c8153a9e49\",\"userOptionId\":\"0.67765225719441870.424907026276\"}],\"structureAlias\":\"短文理解\",\"structureId\":\"a9694b698fb211e793086c92bf20e479\"}],\"totalNum\":\"25\",\"useTime\":\"21\"}";
        this.mockMvc.perform(
                post("/v1/exam/papers/submit")
                        .header(HttpHeaders.AUTHORIZATION, getdbHeader("8a987df75b45fdc8015b6043fc504198"))
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status()
                        .is2xxSuccessful());
    }

    @Test
    public void submitJson2() throws Exception {
        String json = "{\n" +
                "  \"didNum\": \"30\",\n" +
                "  \"totalNum\": \"30\",\n" +
                "  \"useTime\": \"30\",\n" +
                "  \"paperId\": \"57314dd9c22988c8153a99d8\",\n" +
                "  \"paperType\": 2,\n" +
                "  \"paperStructureId\": \"a5b4694a8fb211e793086c92bf20e479\",\n" +
                "  \"questionList\": [\n" +
                "    {\n" +
                "      \"id\": \"57314dd9c22988c8153a99d6\",\n" +
                "      \"questionItemList\": [\n" +
                "        {\n" +
                "          \"id\": \"57314dd9c22988c8153a99d5\",\n" +
                "          \"userOptionId\": \"8c89d5C)FoodInstagrammersPose0.3\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"structureAlias\": \"篇章阅读\",\n" +
                "      \"isFinish\": 1,\n" +
                "      \"structureId\": \"4929d0e98d2811e7b07e6c92bf2c1455\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"notDoneNum\": \"0\"\n" +
                "}";
        this.mockMvc.perform(
                post("/v1/exam/papers/submit")
                        .header(HttpHeaders.AUTHORIZATION, getdbHeader("8a987df75b45fdc8015b6043fc504198"))
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status()
                        .is2xxSuccessful());

        }

    /**
     */
    @Test
    @Rollback(true)
    public void submit() throws Exception {
        List<SubmitQuestionItem> questionList = new ArrayList<>();


                    SubmitQuestionSubItem submitQuestionSubItem1 = new SubmitQuestionSubItem();
                    submitQuestionSubItem1.setId("1");
                    submitQuestionSubItem1.setUserOptionId("1");

                    SubmitQuestionSubItem submitQuestionSubItem2 = new SubmitQuestionSubItem();
                    submitQuestionSubItem2.setId("2");
                    submitQuestionSubItem2.setUserOptionId("5");

                List<SubmitQuestionSubItem> questionItemList1 = new ArrayList<>();
                questionItemList1.add(submitQuestionSubItem1);
                questionItemList1.add(submitQuestionSubItem2);

            SubmitQuestionItem submitQuestionItem1 = new SubmitQuestionItem();
                submitQuestionItem1.setId("6");
                submitQuestionItem1.setIsFinish(1);
                submitQuestionItem1.setQuestionItemList(questionItemList1);
                submitQuestionItem1.setStructureId("121");
                submitQuestionItem1.setStructureAlias("长对话");
        questionList.add(submitQuestionItem1);

                    SubmitQuestionSubItem submitQuestionSubItem3 = new SubmitQuestionSubItem();
                    submitQuestionSubItem3.setId("3");
                    submitQuestionSubItem3.setUserOptionId("99");

                    SubmitQuestionSubItem submitQuestionSubItem4 = new SubmitQuestionSubItem();
                    submitQuestionSubItem4.setId("4");
                    submitQuestionSubItem4.setUserOptionId("13");
                List<SubmitQuestionSubItem> questionItemList2 = new ArrayList<>();
                questionItemList2.add(submitQuestionSubItem3);
                questionItemList2.add(submitQuestionSubItem4);

            SubmitQuestionItem submitQuestionItem2 = new SubmitQuestionItem();
            submitQuestionItem2.setId("7");
            submitQuestionItem2.setIsFinish(1);
            submitQuestionItem2.setStructureId("122");
            submitQuestionItem2.setStructureAlias("短对话");
            submitQuestionItem2.setQuestionItemList(questionItemList2);

        questionList.add(submitQuestionItem2);


        SubmitPaper submitPaper = new SubmitPaper();
        submitPaper.setPaperId("1");
        submitPaper.setPaperStructureId("12");
        submitPaper.setPaperType(1);
        submitPaper.setUseTime(1);
        submitPaper.setTotalNum(4);
        submitPaper.setDidNum(4);
        submitPaper.setNotDoneNum(0);
        submitPaper.setQuestionList(questionList);
        String jsonStr = JSON.toJSONString(submitPaper);
        System.out.println(jsonStr);
       this.mockMvc.perform(
                post("/v1/exam/papers/submit")
                        .header(HttpHeaders.AUTHORIZATION, getdbHeader())
                        .content(jsonStr)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status()
                        .is2xxSuccessful());

    }

    /**
     */
    @Test
    public void wrong_books() throws Exception {
        this.mockMvc.perform(
                get("/v1/exam/wrong_books/12").header(HttpHeaders.AUTHORIZATION, getBaseHeader()).characterEncoding("UTF-8")).andDo(print()).andExpect(status().is2xxSuccessful());

    }




}
