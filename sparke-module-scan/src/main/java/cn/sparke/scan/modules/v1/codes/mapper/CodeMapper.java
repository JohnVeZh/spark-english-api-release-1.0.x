package cn.sparke.scan.modules.v1.codes.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.scan.modules.v1.codes.bean.CodeBean;
import cn.sparke.scan.modules.v1.codes.bean.TbQrCode;
import cn.sparke.scan.modules.v1.codes.bean.easy.*;
import cn.sparke.scan.modules.v1.codes.bean.gift.GiftVideo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghaiguang on 2017/7/10.
 */
public interface CodeMapper extends BaseMapper<CodeBean> {

    TbQrCode queryFullByQrCode(@Param("qrCode") String qrCode);

    //根据二维码(qr_code),获取二维码类型
    CodeBean queryByQrCode(String qrCode);

    //根据二维码、学段,获取考场原音(String qrCode,Integer sectionCoe)
    PaperCatalogeBean queryPaperCatalogByCode(Map<String,Object> map);

    //根据二维码,获取碎片(String qrCode)
    FragmentationBean queryFragmentByCode(String qrCode);

    //根据二维码,获取简视频(String qrCode)
    List<NetworkVideoBean> queryNetworkVideoByCode(String qrCode);

    //根据二维码、学段，索取简写作(String qrCode,Integer sectionCoe)
    List<FragmentationBean> queryWritingByCode(Map<String,Object> map);

    //根据二维码，获取字幕听力(String qrCode)
    CaptionListeningBean queryCaptionListeningByCode(String qrCode);

    //根据二维码获取写作翻译类型(String qrCode)
    List<StudyMaterialsWritingBean> queryWritingTranslationByCode(String qrCode);

    //根据二维码获取大礼包视频
    List<GiftVideo> queryGiftVideoByQrCode(String qrCode);

    //判断大礼包是否激活
    Integer giftIsActivated(Map<String,Object> map);





}
