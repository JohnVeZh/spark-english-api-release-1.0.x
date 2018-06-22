package cn.sparke.scan.modules.v1.codes.service.impl;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.scan.modules.v1.codes.bean.CodeBean;
import cn.sparke.scan.modules.v1.codes.bean.TbQrCode;
import cn.sparke.scan.modules.v1.codes.bean.easy.CommonWordBean;
import cn.sparke.scan.modules.v1.codes.bean.easy.NetworkVideoBean;
import cn.sparke.scan.modules.v1.codes.bean.easy.StudyMaterialsWritingBean;
import cn.sparke.scan.modules.v1.codes.bean.support.PaperDetails;
import cn.sparke.scan.modules.v1.codes.constants.QrCodeTargetType;
import cn.sparke.scan.modules.v1.codes.constants.QrCodeTypeConstants;
import cn.sparke.scan.modules.v1.codes.constants.QrCodeUseScene;
import cn.sparke.scan.modules.v1.codes.mapper.CodeMapper;
import cn.sparke.scan.modules.v1.codes.mapper.GiftMapper;
import cn.sparke.scan.modules.v1.codes.mapper.PaperMapper;
import cn.sparke.scan.modules.v1.codes.service.GiftServiceApi;
import cn.sparke.scan.modules.v1.codes.service.ICodeService;
import cn.sparke.scan.modules.v1.common.MapUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghaiguang on 2017/7/11.
 */
@Service
@Transactional
public class CodeServiceImpl implements ICodeService {

    @Autowired
    private CodeMapper codeMapper;

    @Autowired
    private GiftMapper giftMapper;

    @Autowired
    private EasyService easyService;

    @Autowired
    private SupportService supportService;

    @Autowired
    private GiftService giftService;


    @Override
    public CodeBean queryByQrCode(String qrCode) {
        CodeBean codeBean = new CodeBean();
        //获取二维码
        TbQrCode code = codeMapper.queryFullByQrCode(qrCode);
        if (code != null) {
            fillCodeBean(code, codeBean);

            AuthEntity entity = ContextUtils.getCurAuth();
            Integer type = code.getType();


            if (code.getUseScene() == QrCodeUseScene.SUPPORT) {
                //配套专区逻辑
                if (code.getSectionCode() != null && entity.getSectionCode() != code.getSectionCode()) {
                    return new CodeBean(code.getUseScene(), code.getType(), code.getSectionCode());
                }
                supportService.getSupporCodeBean(qrCode,codeBean,code);
            } else if (code.getUseScene() == QrCodeUseScene.EASY) {
                //简系列逻辑
                easyService.getEasyCodeBean(entity,type,qrCode,codeBean,code);
            } else if (code.getUseScene() == QrCodeUseScene.GIFT) {
                // 大礼包逻辑
                String paperId = giftMapper.queryPaperIdByQrCode(qrCode);
                if (code.getType()==QrCodeTypeConstants.GIFT_RECORD_PAPER && code.getTargetType() == QrCodeTargetType.details) {
                    if(StringUtils.isEmpty(paperId)){//试卷不存在
                        codeBean.setIsExistPaper(0);
                        return codeBean;
                    }
                }
                giftService.getGiftCodeBean(entity,paperId,qrCode,codeBean,code);

            }
        }
        return codeBean;
    }
    //组装二维码类型和使用场景数据
    private void fillCodeBean(TbQrCode code, CodeBean codeBean) {
        codeBean.setType(code.getType());
        codeBean.setUseScene(code.getUseScene());
    }

    //获取二维码
    public TbQrCode getCode(String qrCode){
        return codeMapper.queryFullByQrCode(qrCode);

    }

    //判断大礼包是否激活
    @Override
    public boolean giftIsActivated() {
        AuthEntity entity = ContextUtils.getCurAuth();
        Map<String, Object> map = MapUtil.setMapValues("sectionCode", entity.getSectionCode(), "userId", entity.getUserId());
        Integer flag = codeMapper.giftIsActivated(map);
        return flag>0;
    }


}
