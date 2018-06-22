package cn.sparke.scan.modules.v1.codes.service.impl;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.scan.modules.v1.codes.bean.CodeBean;
import cn.sparke.scan.modules.v1.codes.bean.TbQrCode;
import cn.sparke.scan.modules.v1.codes.bean.gift.GiftVideo;
import cn.sparke.scan.modules.v1.codes.constants.QrCodeTargetType;
import cn.sparke.scan.modules.v1.codes.constants.QrCodeTypeConstants;
import cn.sparke.scan.modules.v1.codes.mapper.CodeMapper;
import cn.sparke.scan.modules.v1.codes.mapper.GiftMapper;
import cn.sparke.scan.modules.v1.codes.service.GiftServiceApi;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by wanghaiguang on 2017/8/25.
 */
@Service
public class GiftService {

    @Autowired
    private CodeMapper codeMapper;

    @Autowired
    private GiftMapper giftMapper;

    @Autowired
    private GiftServiceApi giftServiceApi;

    public void getGiftCodeBean(AuthEntity entity,String paperId,String qrCode, CodeBean codeBean, TbQrCode code){
        // 大礼包逻辑
        codeBean.setTargetType(code.getTargetType());
        codeBean.setSectionCode(code.getSectionCode());

        if (code.getType() == QrCodeTypeConstants.GIFT_COURSE) { //大礼包扫码看课
            codeBean.setTitle(code.getTitle());
            List<GiftVideo> giftVideos = codeMapper.queryGiftVideoByQrCode(qrCode);
            if(giftVideos!=null && giftVideos.size()==1){
                codeBean.setTargetType(2);
            }
            codeBean.setVideoList(giftVideos);

        }else if(code.getType() == QrCodeTypeConstants.GIFT_RECORD_PAPER) {//大礼包扫码录题
            //返回数据
            if (code.getTargetType() == QrCodeTargetType.list) {//列表
                codeBean.setRecordPaperList(giftServiceApi.recordPaperList(JSON.toJSONString(ContextUtils.getCurAuth())));

            }else if (code.getTargetType() == QrCodeTargetType.details) {//详情
                //获取报告Id
                String reportId = giftMapper.queryReportByPaperId(paperId, entity.getUserId(), entity.getSectionCode());
                if (!StringUtils.isEmpty(reportId)){//报告存在
//                    codeBean.setReportInfo(giftServiceApi.reportInfo(paperId,JSON.toJSONString(ContextUtils.getCurAuth())));
                    codeBean.setReportID(reportId);
                }else {//报告不存在
                    codeBean.setRecordPaperInfo( giftServiceApi.recordPaperInfo(paperId,JSON.toJSONString(ContextUtils.getCurAuth())));
                }
            }
        }

    }

}
