package cn.sparke.base.modules.v1.trafficStatistic.service;

import cn.sparke.base.modules.v1.trafficStatistic.api.IpApi;
import cn.sparke.base.modules.v1.trafficStatistic.entity.TrafficStatisticEntity;
import cn.sparke.base.modules.v1.trafficStatistic.mapper.TrafficStatisticMapper;
import cn.sparke.core.common.utils.ContextUtils;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * 流量统计Dao
 *
 * @author spark
 * @Date 2017-07-31 17:09:22
 */
@Service
public class TrafficStatisticService {
    @Autowired
    private TrafficStatisticMapper trafficStatisticMapper;
    @Autowired
    private IpApi ipApi;

    public void save(TrafficStatisticEntity trafficStatistic) {
        String ip = ContextUtils.getCurAuth().getIp();
        if (StringUtils.isNotBlank(ip)) {
            String map = ipApi.getInfo(ip);
            Map data = (Map) JSON.parseObject(map, Map.class).get("data");
            trafficStatistic.setProvince((String) data.get("region"));
            trafficStatistic.setCity((String) data.get("city"));
        }
        trafficStatistic.preInsert();
        trafficStatisticMapper.insert(trafficStatistic);
    }
}
