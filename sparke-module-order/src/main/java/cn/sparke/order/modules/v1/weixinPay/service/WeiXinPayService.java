package cn.sparke.order.modules.v1.weixinPay.service;

import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.order.modules.v1.order.entity.OrderEntity;
import cn.sparke.order.modules.v1.weixinPay.bean.NameValuePair;
import cn.sparke.order.modules.v1.weixinPay.bean.QrCodeResultBean;
import cn.sparke.order.modules.v1.weixinPay.bean.WeiXinCreateOrderResponse;
import cn.sparke.order.modules.v1.weixinPay.constants.WeiXinConstants;
import cn.sparke.order.modules.v1.weixinPay.constants.WeiXinPayProperties;
import cn.sparke.order.modules.v1.weixinPay.http.WeiXinPayApi;
import cn.sparke.order.modules.v1.weixinPay.utils.WeiXinPayUtils;
import cn.sparke.order.modules.v1.weixinPay.utils.XmlUtil;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by zhangbowen on 2016/7/26.
 */
@Service
public class WeiXinPayService {
    private Logger logger = Logger.getLogger(WeiXinPayService.class);
    @Autowired
    private WeiXinPayApi weiXinPayApi;
    @Autowired
    private WeiXinPayProperties weiXinPayProperties;

    private List<NameValuePair> generateRequestParam(OrderEntity orderEntity, int type) {
        String orderNo = orderEntity.getOrderCode();
        BigDecimal orderPrice = orderEntity.getOrderPrice();
        //add的顺序必须保持一致，因为要求按照key的拼音排序
        List<NameValuePair> packageParams = new LinkedList<>();
        packageParams.add(new NameValuePair("appid", weiXinPayProperties.app_id));
        packageParams.add(new NameValuePair("attach", orderEntity.getId()));
        packageParams.add(new NameValuePair("body", "星火英语-订单号" + orderNo));
        packageParams.add(new NameValuePair("mch_id", weiXinPayProperties.mch_id));
        packageParams.add(new NameValuePair("nonce_str", String.valueOf(new Random().nextInt(10000))));
        packageParams.add(new NameValuePair("notify_url", weiXinPayProperties.notify_url));
        packageParams.add(new NameValuePair("out_trade_no", orderEntity.getOrderTradeNo()));
        if (WeiXinConstants.TYPE_PC == type) {
            packageParams.add(new NameValuePair("product_id", orderNo));
        }
        packageParams.add(new NameValuePair("spbill_create_ip", ContextUtils.getCurAuth().getIp()));
        packageParams.add(new NameValuePair("total_fee", String.valueOf(orderPrice.multiply(new BigDecimal(100)).intValue())));//单位分
        if (WeiXinConstants.TYPE_PC == type) {
            packageParams.add(new NameValuePair("trade_type", "NATIVE"));
        } else if (WeiXinConstants.TYPE_APP == type) {
            packageParams.add(new NameValuePair("trade_type", "APP"));
        }
        String sign = WeiXinPayUtils.genPackageSign(packageParams, weiXinPayProperties.pay_key);
        packageParams.add(new NameValuePair("sign", sign));
        return packageParams;
    }

    /**
     * 生成APP支付签名
     *
     * @param orderEntity
     * @return
     */
    public Map<String, String> appPay(OrderEntity orderEntity) {
        List<NameValuePair> packageParams = generateRequestParam(orderEntity, WeiXinConstants.TYPE_APP);
        String resultStr = weiXinPayApi.createOrder(WeiXinPayUtils.toXml(packageParams));
        if (!StringUtils.isEmpty(resultStr)) {
            WeiXinCreateOrderResponse createOrderResponse = XmlUtil.convertToJavaBean(resultStr, WeiXinCreateOrderResponse.class);
            if ("SUCCESS".equals(createOrderResponse.getReturn_code()) && "SUCCESS".equals(createOrderResponse.getResult_code())) {
                return generateResultMap(createOrderResponse);
            }
        }
        return null;
    }

    /**
     * 返回给客户端的签名生成
     *
     * @param createOrderResponse
     * @return
     */
    public Map<String, String> generateResultMap(WeiXinCreateOrderResponse createOrderResponse) {
        List<NameValuePair> packageParams = new LinkedList<>();
        packageParams.add(new NameValuePair("appid", createOrderResponse.getAppid()));
        packageParams.add(new NameValuePair("noncestr", String.valueOf(new Random().nextInt(10000))));
        packageParams.add(new NameValuePair("package", "Sign=WXPay"));
        packageParams.add(new NameValuePair("partnerid", createOrderResponse.getMch_id()));
        packageParams.add(new NameValuePair("prepayid", createOrderResponse.getPrepay_id()));
        packageParams.add(new NameValuePair("timestamp", String.valueOf(System.currentTimeMillis() / 1000)));
        String sign = WeiXinPayUtils.genPackageSign(packageParams, weiXinPayProperties.pay_key);
        packageParams.add(new NameValuePair("sign", sign));
        Map<String, String> result = new HashMap<>();
        for (NameValuePair packageParam : packageParams) {
            result.put(packageParam.getName(), packageParam.getValue());
        }
        return result;
    }


    /**
     * pc网站二维码生成
     *
     * @param orderEntity
     * @return
     */
    public QrCodeResultBean pcPay(OrderEntity orderEntity) {
        List<NameValuePair> packageParams = generateRequestParam(orderEntity, WeiXinConstants.TYPE_PC);
        String resultStr = weiXinPayApi.createOrder(WeiXinPayUtils.toXml(packageParams));
        if (!StringUtils.isEmpty(resultStr)) {
            WeiXinCreateOrderResponse createOrderResponse = XmlUtil.convertToJavaBean(resultStr, WeiXinCreateOrderResponse.class);
            if ("SUCCESS".equals(createOrderResponse.getReturn_code()) && "SUCCESS".equals(createOrderResponse.getResult_code())) {
                return new QrCodeResultBean(createOrderResponse.getCode_url());
            }
        }
        return null;
    }
}
