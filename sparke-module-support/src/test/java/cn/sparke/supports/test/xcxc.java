package cn.sparke.supports.test;

import cn.sparke.support.modules.v1.exam.bean.submit.po.TbQuestionWrongBook;
import cn.sparke.support.modules.v1.exam.mapper.report.TbQuestionWrongBookMapper;
import cn.sparke.supports.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/31 16:55
 */
public class xcxc extends BaseTest {

    @Resource
    private TbQuestionWrongBookMapper questionWrongBookMapper;

    @Test
    public void test1(){
        List<TbQuestionWrongBook> questionWrongBookList = questionWrongBookMapper.findByPaperIdAndUserId("234234", "234234");
        //获取用户错题本问题大题ID
        List<String> questionWrongBookIdList = questionWrongBookList.stream().map(TbQuestionWrongBook::getQuestionId).collect(Collectors.toList());
        System.out.printf("1111");
    }
}
