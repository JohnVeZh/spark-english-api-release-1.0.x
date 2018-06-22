package cn.sparke.core.common.interceptor;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.core.common.utils.Utils;
import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangbowen on 2015/12/4.
 * 全局拦截器
 */
public class ContextInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        AuthEntity authEntity = generateAuthEntity(request);
        authEntity.setIp(Utils.getAddress(request));
        authEntity.setUri(request.getRequestURI());
        ContextUtils.setCurAuth(authEntity);
        return true;
    }

    private static AuthEntity generateAuthEntity(HttpServletRequest request) {
        String authStr = request.getHeader(HttpHeaders.AUTHORIZATION);
        AuthEntity authEntity = new AuthEntity();
        if (!StringUtils.isEmpty(authEntity)) {
            //设置当前请求者的权限标识
            try {
                authEntity = JSON.parseObject(authStr, AuthEntity.class);
            } catch (Exception ignored) {
                return authEntity;
            }
        }
        if (authEntity == null) {
            authEntity = new AuthEntity();
        }
        return authEntity;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        //删除当前请求者的权限标识
        ContextUtils.removeCurAuth();
    }
}
