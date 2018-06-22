package cn.sparke.order.modules.v1.alipay.service;

import cn.sparke.order.modules.v1.alipay.constants.AliPayProperties;
import cn.sparke.order.modules.v1.order.entity.OrderEntity;
import cn.sparke.order.modules.v1.pay.bean.AliFormResultBean;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by zhangbowen on 2017/5/27.
 */
@Service
public class AliPayService {
    private AlipayClient alipayClient = null;
    @Autowired
    private AliPayProperties aliPayProperties;
    private static final String BODY = "星火英语";
    private static final String SUBJECT = "星火英语-订单号";

    @PostConstruct
    public void init() {
        alipayClient = new DefaultAlipayClient(aliPayProperties.server_url, aliPayProperties.app_id, aliPayProperties.private_key, "json", "utf-8", aliPayProperties.public_key, "RSA2");
    }

    private AlipayTradeAppPayRequest generateAppRequest(OrderEntity orderEntity) {
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody(BODY);
        model.setSubject(SUBJECT + orderEntity.getOrderCode());
        model.setOutTradeNo(orderEntity.getOrderTradeNo());
        model.setTotalAmount(orderEntity.getOrderPrice().toPlainString());
        model.setProductCode("QUICK_MSECURITY_PAY");
        model.setPassbackParams(orderEntity.getId());
        request.setBizModel(model);
        request.setNotifyUrl(aliPayProperties.notify_url);
        return request;
    }

    public String appSign(OrderEntity orderEntity) {
        try {
            AlipayTradeAppPayRequest request = generateAppRequest(orderEntity);
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            return response.getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    private AlipayTradePagePayRequest generatePcRequest(OrderEntity orderEntity) {
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setBody(BODY);
        model.setSubject(SUBJECT + orderEntity.getOrderCode());
        model.setOutTradeNo(orderEntity.getOrderTradeNo());
        model.setTotalAmount(orderEntity.getOrderPrice().toPlainString());
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
        model.setPassbackParams(orderEntity.getId());
        request.setBizModel(model);
        request.setNotifyUrl(aliPayProperties.notify_url);
        return request;
    }

    public AliFormResultBean pcForm(OrderEntity orderEntity) {
        try {
            AlipayTradePagePayRequest request = generatePcRequest(orderEntity);
            request.setReturnUrl(aliPayProperties.pc_return_url);
            return new AliFormResultBean(alipayClient.pageExecute(request).getBody());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    private AlipayTradeWapPayRequest generateWapRequest(OrderEntity orderEntity) {
        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
        AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
        model.setBody(BODY);
        model.setSubject(SUBJECT + orderEntity.getOrderCode());
        model.setOutTradeNo(orderEntity.getOrderTradeNo());
        model.setTotalAmount(orderEntity.getOrderPrice().toPlainString());
        model.setProductCode("QUICK_WAP_PAY");
        model.setPassbackParams(orderEntity.getId());
        request.setBizModel(model);
        request.setNotifyUrl(aliPayProperties.notify_url);
        return request;
    }

    public AliFormResultBean mForm(OrderEntity orderEntity) {
        try {
            AlipayTradeWapPayRequest request = generateWapRequest(orderEntity);
            request.setReturnUrl(aliPayProperties.m_return_url);
            return new AliFormResultBean(alipayClient.pageExecute(request).getBody());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }
}
