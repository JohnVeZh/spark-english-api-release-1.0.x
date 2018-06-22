package cn.sparke.core.common.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Random;
import java.util.UUID;

/**
 * Created by zhangbowen on 2015/12/4.
 */
public class Utils {
    public static final int MINUTE = 60;
    public static final int HOUR = MINUTE * 60;

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    /**
     * 根据手机号生成用户名
     *
     * @param phone
     * @return
     */
    public static String generateNameByPhone(String phone) {
        return phone.substring(0, 3) + "****" + phone.substring(7);
    }

    /**
     * 生成短信验证码
     *
     * @return
     */
    public static String generateSmsCode() {
        return String.valueOf((int) (Math.random() * 9000) + 1000);
    }

    /**
     * 获取ip地址,防止集群、代理
     *
     * @param request
     * @return ip
     */
    public static String getAddress(HttpServletRequest request) {
        try {
            return NetworkUtil.getIpAddress(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean isMobile(HttpServletRequest request) {
        boolean isMobile = false;

        String[] mobileAgents = {"MIDP",
                "WAP",
                "UP.Browser", "Smartphone", "Obigo", "Mobile", "AU.Browser", "wxd.Mms", "WxdB.Browser",
                "CLDC", "UP.Link", "KM.Browser", "UCWEB", "SEMC-Browser", "Mini", "Symbian", "Palm", "Nokia", "Panasonic",
                "MOT-",
                "SonyEricsson", "NEC-", "Alcatel", "Ericsson", "BENQ", "BenQ", "Amoisonic",
                "Amoi-", "Capitel", "PHILIPS", "SAMSUNG", "Lenovo", "Mitsu", "Motorola", "SHARP", "WAPPER", "LG-", "LG/",
                "EG900", "CECT", "Compal", "kejian", "Bird", "BIRD", "G900/V1.0", "Arima", "CTL", "TDG", "Daxian", "DAXIAN", "DBTEL", "Eastcom", "EASTCOM",
                "PANTECH", "Dopod", "Haier", "HAIER", "KONKA", "KEJIAN", "LENOVO", "Soutec", "SOUTEC", "SAGEM", "SEC-", "SED-", "EMOL-",
                "INNO55", "ZTE", "iPhone", "Android", "Windows CE", "Wget", "Java", "curl", "Opera"};
        if (request.getHeader("User-Agent") != null) {
            for (String mobileAgent : mobileAgents) {
                if (request.getHeader("User-Agent").toLowerCase().contains(mobileAgent.toLowerCase())) {
                    isMobile = true;
                    break;
                }
            }
        }
        return isMobile;
    }

    /**
     * 获得classpath下的文件流
     *
     * @param path
     * @return
     */
    public static InputStream getClassPathFileStream(String path) {
        Resource resource = new ClassPathResource(path);
        if (resource.isReadable()) {
            //每次都会打开一个新的流
            try {
                return resource.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Class getSuperClassGenericType(final Class clazz, final int index) {
        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        //返回表示此类型实际类型参数的 Type 对象的数组。
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }
}
