package cn.sparke.order.modules.v1.weixinPay.http;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by zhangbowen on 2016/7/26.
 */
@FeignClient(name = "WeiXinPay", url = "https://api.mch.weixin.qq.com")
public interface WeiXinPayApi {
    /**
     * 下单
     *
     * @param orderInfo
     * @return
     */
    @PostMapping("/pay/unifiedorder")
    String createOrder(@RequestBody String orderInfo);
}
