package cn.sparke.scan.modules.v1.codes.service.impl;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.scan.modules.v1.codes.bean.CodeBean;
import cn.sparke.scan.modules.v1.codes.bean.TbQrCode;
import cn.sparke.scan.modules.v1.codes.bean.easy.CommonWordBean;
import cn.sparke.scan.modules.v1.codes.bean.easy.NetworkVideoBean;
import cn.sparke.scan.modules.v1.codes.bean.easy.StudyMaterialsWritingBean;
import cn.sparke.scan.modules.v1.codes.constants.QrCodeTypeConstants;
import cn.sparke.scan.modules.v1.codes.mapper.CodeMapper;
import cn.sparke.scan.modules.v1.common.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghaiguang on 2017/8/25.
 */
@Service
public class EasyService {

    @Autowired
    private CodeMapper codeMapper;

    //获取二维码详情
    public void getEasyCodeBean(AuthEntity entity,Integer type,String qrCode,CodeBean codeBean,TbQrCode code){
        //原有逻辑(简系类)
        codeBean.setSectionCode(code.getSectionCode());

        //根据二维码类型,向实体放入不同的数据
        if (type == QrCodeTypeConstants.EXAMINATION_ACOUSTIC) {//查询考场原音
            //将sql查询参数放入map中
            Map<String, Object> map = MapUtil.setMapValues("qrCode", qrCode, "sectionCode", entity.getSectionCode());
            codeBean.setPaperCatalogInfo(codeMapper.queryPaperCatalogByCode(map));
        } else if (type == QrCodeTypeConstants.FRAGMENTAION) {//查询碎片
            codeBean.setFragmentInfo(codeMapper.queryFragmentByCode(qrCode));
        } else if (type == QrCodeTypeConstants.SIMPLE_VIDEO) {//查询简视频
            List<NetworkVideoBean> beans = codeMapper.queryNetworkVideoByCode(qrCode);
            if (beans!=null){
                codeBean.setVideoCatalogInfo(beans.get(0));
            }
        } else if (type == QrCodeTypeConstants.SIMPLE_WRITING) {//查询简写作
            Map<String, Object> map = MapUtil.setMapValues("qrCode", qrCode, "sectionCode", entity.getSectionCode());
            codeBean.setWritingList(codeMapper.queryWritingByCode(map));
        } else if (type == QrCodeTypeConstants.COMMON_WORD) {//查询常用词汇
            CommonWordBean commonWordBean = new CommonWordBean();
            commonWordBean.setSectionCode(entity.getSectionCode());
            codeBean.setCommonWord(commonWordBean);
        } else if (type == QrCodeTypeConstants.CAPTION_LISTENING) {//查询字幕听力
            codeBean.setCaptionListeningInfo(codeMapper.queryCaptionListeningByCode(qrCode));
        } else if (type == QrCodeTypeConstants.WRITING_TRANSLATION_READING) {//查询写作翻译阅读
            List<StudyMaterialsWritingBean> beans = codeMapper.queryWritingTranslationByCode(qrCode);
            if (beans!=null){
                codeBean.setWritingTranslation(beans.get(0));
            }

        }


    }





}
