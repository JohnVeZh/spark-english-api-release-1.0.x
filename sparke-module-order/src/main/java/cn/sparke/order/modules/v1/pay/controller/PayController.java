package cn.sparke.order.modules.v1.pay.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.interceptor.LogInterceptor;
import cn.sparke.order.modules.v1.alipay.constants.AliPayProperties;
import cn.sparke.order.modules.v1.order.constants.OrderConstants;
import cn.sparke.order.modules.v1.pay.bean.CallBackBean;
import cn.sparke.order.modules.v1.pay.service.PayService;
import cn.sparke.order.modules.v1.weixinPay.bean.WeiXinPayNotifyBean;
import cn.sparke.order.modules.v1.weixinPay.bean.WeiXinPayResultBean;
import cn.sparke.order.modules.v1.weixinPay.constants.WeiXinPayProperties;
import cn.sparke.order.modules.v1.weixinPay.utils.WeiXinPayUtils;
import cn.sparke.order.modules.v1.weixinPay.utils.XmlUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangbowen on 2017/7/14.
 */
@RestController
@RequestMapping("/${version}/pay")
public class PayController {
    @Autowired
    private PayService payService;
    @Autowired
    private AliPayProperties aliPayProperties;
    @Autowired
    private WeiXinPayProperties weiXinPayProperties;
    @Autowired
    private HttpServletRequest request;
    private static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    /**
     * 支付调起
     *
     * @param type
     * @return
     */
    @GetMapping("/{orderId}")
    @LoginAnnot
    public ResponseEntity pays(@PathVariable String orderId, @RequestParam Integer type) {
        return payService.getSignStr(orderId, type);
    }

    @PostMapping("/ali/callback")
    public String aliCallBack() {
        Map<String, String> params = getAllRequestParam(request);
        try {
            boolean flag = AlipaySignature.rsaCheckV1(params, aliPayProperties.public_key, "utf-8", "RSA2");
            if (flag) {
                if (params.get("trade_status").equals("TRADE_SUCCESS")) {
                    CallBackBean callBackBean = new CallBackBean();
                    callBackBean.setOrderId(params.get("passback_params"));
                    callBackBean.setOrderTradeNo(params.get("out_trade_no"));
                    callBackBean.setTrade_no(params.get("trade_no"));
                    callBackBean.setPayType(OrderConstants.PAY_TYPE.ALI_PAY);
                    callBackBean.setPayPrice(new BigDecimal(params.get("total_amount")));
                    boolean success = payService.payCallBack(callBackBean);
                    if (success) {
                        return "success";
                    }
                }
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return "fail";
        }
        return "fail";
    }

    /**
     * 微信支付回调
     *
     * @return
     */
    @PostMapping("/weixin/callback")
    public ResponseEntity weiXinCallBack(@RequestBody String xml) {
        if (StringUtils.isBlank(xml)) {
            return new ResponseErrorEntity(StatusCode.VALIDATE_CODE_ERROR, HttpStatus.BAD_REQUEST);
        }
        if (!WeiXinPayUtils.isSignatureValid(xml, weiXinPayProperties.pay_key)) {
            return ResponseEntity.ok(XmlUtil.convertToXml(new WeiXinPayResultBean("FAIL", "ERROR")));
        }
        WeiXinPayNotifyBean notifyBean = XmlUtil.convertToJavaBean(xml, WeiXinPayNotifyBean.class);
        if ("SUCCESS".equals(notifyBean.getReturn_code()) && "SUCCESS".equals(notifyBean.getResult_code())) {
            CallBackBean callBackBean = new CallBackBean();
            callBackBean.setOrderId(notifyBean.getAttach());
            callBackBean.setOrderTradeNo(notifyBean.getOut_trade_no());
            callBackBean.setTrade_no(notifyBean.getTransaction_id());
            callBackBean.setPayType(OrderConstants.PAY_TYPE.WEI_XIN);
            callBackBean.setPayPrice(new BigDecimal(notifyBean.getTotal_fee()).divide(new BigDecimal(100), 2, RoundingMode.UP));
            boolean success = payService.payCallBack(callBackBean);
            if (success) {
                return ResponseEntity.ok(XmlUtil.convertToXml(new WeiXinPayResultBean("SUCCESS", "OK")));
            }
        } else {
            logger.warn("微信支付回调结果失败：");
            logger.warn("code：" + notifyBean.getReturn_code());
            logger.warn("msg：" + notifyBean.getReturn_msg());
            logger.warn("resultCode：" + notifyBean.getResult_code());
            logger.warn("resultErrorCode：" + notifyBean.getErr_code());
            logger.warn("resultErrorMsg：" + notifyBean.getErr_code_des());
        }
        return ResponseEntity.ok(XmlUtil.convertToXml(new WeiXinPayResultBean("FAIL", "ERROR")));
    }


    /**
     * 获取请求参数中所有的信息
     *
     * @param request
     * @return
     */
    private static Map<String, String> getAllRequestParam(final HttpServletRequest request) {
        Map<String, String> res = new HashMap<String, String>();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                if (StringUtils.isNotBlank(value)) {
                    res.put(en, value);
                }
            }
        }
        return res;
    }
}
