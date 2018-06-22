package cn.sparke.base.modules.v1.trafficStatistic.entity;


import cn.sparke.core.common.bean.BaseEntity;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.math.*;

/**
 * 流量统计Entity
 *
 * @author spark
 * @Date 2017-07-31 17:09:22
 */
public class TrafficStatisticEntity extends BaseEntity {
    //渠道代码(字典表value值)
    @NotNull
    private String channelCode;
    //操作类型(1、打开2、下载)
    @NotNull
    private Integer operationType;
    //操作平台（1、andriod 2、ios 3、pc 4、其他）
    @NotNull
    private Integer fromType;
    //来源ip
    private String ip;
    //来源所属省
    private String province;
    //来源市
    private String city;

    public String getChannelCode() {
        return channelCode;
    }
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }
    public void setOperationType(Integer operationType){
        this.operationType = operationType;
    }
    public Integer getOperationType(){
        return this.operationType;
    }
    public void setFromType(Integer fromType){
        this.fromType = fromType;
    }
    public Integer getFromType(){
        return this.fromType;
    }
    public void setIp(String ip){
        this.ip = ip;
    }
    public String getIp(){
        return this.ip;
    }
    public void setProvince(String province){
        this.province = province;
    }
    public String getProvince(){
        return this.province;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }

}
