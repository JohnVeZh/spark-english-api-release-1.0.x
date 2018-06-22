package cn.sparke.core.modules.sms.service.LMobile.bean;

/**
 * Created by Administrator on 2017/7/10.
 */
public class SmsTemplate {
    /**
     * 根据不同类型获取不同模版，暂时共用同一模板
     * @param type 类型
     * @param code 二维码
     * @return
     */
    public static String getContent(int type,String code){
        String content = "";
        switch (type){
            case 1:
                content = "  验证码：" + code + "，客服热线4006231860。 http://www.sparke.cn。";
                break;
            case 2:
                content = "  验证码：" + code + "，客服热线4006231860。 http://www.sparke.cn。";
                break;
            case 3:
                content = "  验证码：" + code + "，客服热线4006231860。 http://www.sparke.cn。";
                break;
            case 4:
                content = "  验证码：" + code + "，客服热线4006231860。 http://www.sparke.cn。";
                break;
            case 5:
                content = "  验证码：" + code + "，客服热线4006231860。 http://www.sparke.cn。";
                break;
            default:
                content = "  验证码：" + code + "，客服热线4006231860。 http://www.sparke.cn。";
                break;
        }
        return content;
    }
}
