package cn.sparke.order.modules.v1.order.utils;

import cn.sparke.core.common.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public class OrderUtils {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 生成订单号
     *
     * @return
     */
    public static String generateOrderCode() {
        return simpleDateFormat.format(new Date()) + Utils.generateSmsCode();
    }
}
