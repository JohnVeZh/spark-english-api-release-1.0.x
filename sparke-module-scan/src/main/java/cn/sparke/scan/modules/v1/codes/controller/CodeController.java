package cn.sparke.scan.modules.v1.codes.controller;

import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.bean.ResultError;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.scan.modules.v1.codes.bean.CodeBean;
import cn.sparke.scan.modules.v1.codes.bean.TbQrCode;
import cn.sparke.scan.modules.v1.codes.bean.gift.GiftVideo;
import cn.sparke.scan.modules.v1.codes.constants.QrCodeTypeConstants;
import cn.sparke.scan.modules.v1.codes.constants.QrCodeUseScene;
import cn.sparke.scan.modules.v1.codes.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * Created by wanghaiguang on 2017/7/10.
 * 简系列扫码controller
 */
@RestController
@RequestMapping("/${version}")
public class CodeController {

    @Autowired
    private ICodeService codeService;

    /**
     * 根据二维码(qr_code),获取详情
     * @param qr_code
     * @return
     */
    @GetMapping ("/codes")
    public ResponseEntity queryByQrCode(@RequestParam String qr_code) {

        //过滤二维码
        String MyQrCode=filterQrCode(qr_code);

        TbQrCode code = codeService.getCode(MyQrCode);
        //二维码不存在
        if (code==null){
            return new ResponseErrorEntity(new ResultError(StatusCode.CODE_NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        //大礼包未激活
        if (code.getUseScene()== QrCodeUseScene.GIFT){
            if(!codeService.giftIsActivated()) {
                return new ResponseErrorEntity(new ResultError(StatusCode.GIFT_NOT_ACTIVATED), HttpStatus.BAD_REQUEST);
            }
        }

        CodeBean codeBean = codeService.queryByQrCode(MyQrCode);

        //试卷是否存在
        if(codeBean!=null && codeBean.getType()== QrCodeTypeConstants.GIFT_RECORD_PAPER && codeBean.getIsExistPaper()!=null && codeBean.getIsExistPaper()!=1){
            return new ResponseErrorEntity(new ResultError(StatusCode.GIFT_PAPER_NOT_FOUNT), HttpStatus.NOT_FOUND);
        }

        //视频是否存在

        if(code.getUseScene()== QrCodeUseScene.GIFT && codeBean!=null){
            List<GiftVideo> videoList = codeBean.getVideoList();
            if(videoList!=null && videoList.size()==0){
                return new ResponseErrorEntity(new ResultError(StatusCode.VIDEO_NOT_FOUNT), HttpStatus.NOT_FOUND);
            }
        }
        return ResponseEntity.ok(codeBean);
    }

    //过滤二维码方法
    private String filterQrCode(String qr_code){
        //        String qr_code="http://biz.cli.im/pro/UcknoI"; //字幕听力
        //        String qr_code="MSSPXQ6&id=4-2017.6-1-2"; //名师视频
        //        String qr_code="http://m.sparke.cn/download.html?user=dlb&type=1&qrcode=cet4_1"; //大礼包
        //        String qr_code="http://qr.sparke.cn/Index/d.html??DSQ174-1"; //简系列
        //        String qr_code="http://qr.sparke.cn/Index/d.html?DSQ174-1"; //黑旋风


        if(qr_code.contains("%3D")|| qr_code.contains("http")){
            try {
                qr_code = URLDecoder.decode(qr_code,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if(qr_code.contains("biz.cli.im")){
            qr_code=qr_code.substring(qr_code.lastIndexOf("/")+1);
            return qr_code;
        }else if(qr_code.contains("MSSPXQ4")||qr_code.contains("MSSPXQ6")){
            qr_code=qr_code.substring(qr_code.indexOf("id")+3);
            return qr_code;
        }else if(qr_code.contains("m.sparke.cn/download.html?user=dlb")){
            qr_code=qr_code.substring(qr_code.indexOf("qrcode")+7);
            return qr_code;
        }else if(qr_code.contains("qr.sparke.cn/Index/d.html??")){
            qr_code=qr_code.substring(qr_code.indexOf("??")+2);
            return qr_code;
        }else if(qr_code.contains("qr.sparke.cn/Index/d.html?")){
            qr_code=qr_code.substring(qr_code.indexOf("?")+1);
            return qr_code;
        }else {
            return qr_code;
        }
    }


}
