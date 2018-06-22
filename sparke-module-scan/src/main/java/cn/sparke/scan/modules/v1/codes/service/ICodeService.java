package cn.sparke.scan.modules.v1.codes.service;

import cn.sparke.scan.modules.v1.codes.bean.CodeBean;
import cn.sparke.scan.modules.v1.codes.bean.TbQrCode;

/**
 * Created by wanghaiguang on 2017/7/11.
 */
public interface ICodeService {

    //根据二维码(qr_code),获取二维码相应详情
    CodeBean queryByQrCode(String qrCode);
    //判断二维码是否存在
    public TbQrCode getCode(String qrCode);

    //判断大礼包是否激活
    boolean giftIsActivated();


}
