package cn.sparke.scan.modules.v1.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanghaiguang on 2017/7/13.
 */
public class MapUtil {


    //将值放入Map集合中
    public static Map<String, Object> setMapValues(String key1, Object value1,String key2,Object value2){
        Map<String, Object> map = new HashMap<>();
        map.put(key1,value1);
        map.put(key2,value2);
        return map;
    }
    //将值放入Map集合中
    public static Map<String, Object> setMapValues(String key1, Object value1,String key2,Object value2,String key3,Object value3){
        Map<String, Object> map = new HashMap<>();
        map.put(key1,value1);
        map.put(key2,value2);
        map.put(key3,value3);
        return map;
    }
    //将值放入传入的Map集合中
    public static Map<String, Object> setMapValues(Map<String, Object> myMap,String key1, Object value1,String key2,Object value2){
        myMap.put(key1,value1);
        myMap.put(key2,value2);
        return myMap;
    }
}
