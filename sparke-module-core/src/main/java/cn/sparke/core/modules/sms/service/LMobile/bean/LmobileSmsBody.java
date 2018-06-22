package cn.sparke.core.modules.sms.service.LMobile.bean;

/**
 * Created by Administrator on 2017/7/8.
 */
public class LmobileSmsBody {
    //接收号码间用英文半角逗号“,”隔开，触发产品一次只能提交一个,其他产品一次不能超过10万个号码
    public String sdst;
    //信息内容, UTF-8编码，通常为70汉字以内，具体由平台内部决定
    public String smsg;

    public String getSdst() {
        return sdst;
    }

    public void setSdst(String sdst) {
        this.sdst = sdst;
    }

    public String getSmsg() {
        return smsg;
    }

    public void setSmsg(String smsg) {
        this.smsg = smsg;
    }
}
