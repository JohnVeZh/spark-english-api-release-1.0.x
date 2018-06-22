package cn.sparke.goods.modules.v1.utils;

import cn.sparke.core.common.mybatis.utils.PagerUtils;
//import org.hashids.Hashids;

import java.util.UUID;

/**
 * Created by yangye on 2017/7/13.
 */
public class CommUtil extends PagerUtils {

    // 获取uuid
    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /*public static String encodeHashStr(Long phone) {
        Hashids hashids = new Hashids("spark_english");
        String hashStr = hashids.encode(phone);
        return hashStr;
    }

    public static Long decodeHashStr(String hashStr) {
        Hashids hashids = new Hashids("spark_english");
        long[] numbers = hashids.decode(hashStr);
        return numbers[0];
    }

    public static void main(String[] args) {
        String encodeStr = encodeHashStr(151061895870000L);
        System.out.println("encodeStr: " + encodeStr);
        System.out.println("decodeStr: " + decodeHashStr(encodeStr));
    }*/
}
