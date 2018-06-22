package cn.sparke.scan.modules.v1.codes.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.scan.modules.v1.codes.bean.CodeBean;
import org.apache.ibatis.annotations.Param;

/**
 * Created by wanghaiguang on 2017/7/10.
 */
public interface GiftMapper extends BaseMapper<CodeBean> {


   //根据二维码查询试卷
   String queryPaperIdByQrCode(String qr_code);

   //根据试卷id查询报告
   String queryReportByPaperId(@Param("paperId") String paperId,@Param("userId") String userId,@Param("sectionCode") Integer sectionCode);


}
