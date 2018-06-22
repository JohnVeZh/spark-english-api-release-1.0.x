package cn.sparke.core.modules.sms.service.LMobile;

import cn.sparke.core.modules.sms.ISmsService;
import cn.sparke.core.modules.sms.bean.SendCodeBean;
import cn.sparke.core.modules.sms.service.LMobile.bean.SmsTemplate;
import cn.sparke.core.modules.sms.service.LMobile.constants.LmobileSmsProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 百分联通短信服务
 * Created by Administrator on 2017/7/8.
 */
public class LmobileSmsService implements ISmsService {
    private LmobileSmsProperties lmobileSmsProperties;

    public LmobileSmsService(LmobileSmsProperties lmobileSmsProperties) {
        this.lmobileSmsProperties = lmobileSmsProperties;
    }

    @Override
    public boolean sendSmsCode(SendCodeBean sendCodeBean) {
        //接收号码间用英文半角逗号“,”隔开，触发产品一次只能提交一个,其他产品一次不能超过10万个号码
        String sdst = sendCodeBean.getPhone();
        //信息内容, UTF-8编码，通常为70汉字以内，具体由平台内部决定
        String smsg = SmsTemplate.getContent(sendCodeBean.getType(),sendCodeBean.getCode());
        //发送结果状态
        boolean status = false;
        String postData = "sname=" + lmobileSmsProperties.sname + "&spwd=" + lmobileSmsProperties.spwd + "&scorpid=&sprdid=" + lmobileSmsProperties.sprdid + "&sdst=" + sdst + "&smsg=" + smsg;

        //发送POST请求
        URL url = null;
        try {
            url = new URL(lmobileSmsProperties.url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);
            out.flush();
            out.close();
            //获取响应状态
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String line;StringBuilder result = new StringBuilder();
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                while ((line = in.readLine()) != null) {
                    result.append(line).append("\n");
                }
                in.close();
                if (result.toString().replace("<State>0</State>", "").length() < result.length()) {
                    status = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }
}
