package cn.sparke.base.modules.v1.trafficStatistic.controller;

import cn.sparke.base.modules.v1.trafficStatistic.entity.TrafficStatisticEntity;
import cn.sparke.base.modules.v1.trafficStatistic.service.TrafficStatisticService;
import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.core.common.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;


/**
 * 流量统计控制器
 *
 * @author spark
 * @Date 2017-07-31 17:09:22
 */
@RestController
@RequestMapping("/${version}/trafficStatistic")
public class TrafficStatisticController  {

     @Autowired
     private TrafficStatisticService trafficStatisticService;
    final static Pattern pattern = Pattern.compile("(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)");



    /**
     * 新增流量统计
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity add(HttpServletRequest request, @Validated TrafficStatisticEntity entity) {

        String []ips = ContextUtils.getCurAuth().getIp().split(",");
        if(ips.length>0){
            String ip = ips[0];
            boolean result = pattern.matcher(ip).find();
            if(result){
                entity.setIp(ip);
                trafficStatisticService.save(entity);
                return new ResponseEntity(HttpStatus.CREATED);
            }
        }

        return new ResponseEntity(HttpStatus.OK);
    }

//    public String getIP(HttpServletRequest request){
//        String ip = request.getHeader("x-forwarded-for");
//        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//        return ip;
//    }
}
