package cn.sparke.core.common.utils;


import cn.sparke.core.common.bean.AuthEntity;

/**
 * Created by zhangbowen on 2016/1/21.
 */
public class ContextUtils {
    private static ThreadLocal<AuthEntity> authEntityThreadLocal = new ThreadLocal<>();

    //获得当前请求者的权限标识
    public static AuthEntity getCurAuth() {
        AuthEntity authEntity = authEntityThreadLocal.get();
        return authEntity == null ? new AuthEntity() : authEntity;
    }

    //设置当前请求者的权限标识
    public static void setCurAuth(AuthEntity authEntity) {
        authEntityThreadLocal.set(authEntity);
    }

    //删除当前请求者的权限标识
    public static void removeCurAuth() {
        authEntityThreadLocal.remove();
    }
}
