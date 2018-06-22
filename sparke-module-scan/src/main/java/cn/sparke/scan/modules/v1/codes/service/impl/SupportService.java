package cn.sparke.scan.modules.v1.codes.service.impl;

import cn.sparke.scan.modules.v1.codes.bean.CodeBean;
import cn.sparke.scan.modules.v1.codes.bean.TbQrCode;
import cn.sparke.scan.modules.v1.codes.bean.support.PaperDetails;
import cn.sparke.scan.modules.v1.codes.constants.QrCodeTargetType;
import cn.sparke.scan.modules.v1.codes.constants.QrCodeTypeConstants;
import cn.sparke.scan.modules.v1.codes.mapper.PaperMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wanghaiguang on 2017/8/25.
 */
@Service
public class SupportService {

    @Resource
    private PaperMapper paperMapper;


    public void getSupporCodeBean(String qrCode, CodeBean codeBean, TbQrCode code){
        codeBean.setTargetType(code.getTargetType());

        if (code.getType() == QrCodeTypeConstants.TEACHER_VIDEO) {
            if (code.getTargetType() == QrCodeTargetType.details) {
                //获取名师视频详情
                codeBean.setTeacherVideo(paperMapper.queryFamousTeacherVideoByQrCode(qrCode));
            }
        } else if (code.getType() == QrCodeTypeConstants.CAPTION) {
            if (code.getTargetType() == QrCodeTargetType.list) {
                List<PaperDetails> paperDetailsList = paperMapper.findByCatalogQrCode(qrCode);
                codeBean.setCaptionPaperList(paperDetailsList);
            } else if (code.getTargetType() == QrCodeTargetType.details) {
                List<PaperDetails> paperDetailsList = paperMapper.findByQrCode(qrCode);
                if(paperDetailsList != null && paperDetailsList.size() >0 ) {
                    codeBean.setCaptionPaper(paperDetailsList.get(0));
                }
            }
        }
    }
}
