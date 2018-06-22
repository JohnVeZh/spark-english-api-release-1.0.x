package cn.sparke.scan.modules.v1.codes.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.scan.modules.v1.codes.bean.CodeBean;
import cn.sparke.scan.modules.v1.codes.bean.support.FamousTeacherVideo;
import cn.sparke.scan.modules.v1.codes.bean.support.PaperDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/17 19:54
 */
public interface PaperMapper extends BaseMapper<CodeBean> {

    //不经过试卷组
    List<PaperDetails> findByQrCode(@Param ( "qrCode" ) String qrCode);

    //经过试卷组
    List<PaperDetails> findByCatalogQrCode(@Param ( "qrCode" ) String qrCode);

    //根据二维码查找名师视频
    FamousTeacherVideo queryFamousTeacherVideoByQrCode(@Param ( "qrCode" ) String qrCode);

}


