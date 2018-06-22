package cn.sparke.base.modules.v1.trafficStatistic.api;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "taobao", url = "http://ip.taobao.com")
public interface IpApi {
    @GetMapping(value = "/service/getIpInfo.php")
    String getInfo(@RequestParam("ip") String ip);
}
