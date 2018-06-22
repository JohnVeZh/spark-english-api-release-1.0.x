package cn.sparke.core.common.interceptor;

import cn.sparke.core.common.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by zhangbowen on 2015/12/4.
 * log日志拦截器
 */
public class LogInterceptor implements HandlerInterceptor {
    /**
     * 日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String method = httpServletRequest.getMethod();
        logger.info("访问者ip:" +
                Utils.getAddress(httpServletRequest) +
                ":" +
                httpServletRequest.getRemotePort() +
                "\n" +
                method +
                ": " +
                httpServletRequest.getRequestURI() +
                "?" +
                httpServletRequest.getQueryString()
        );
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
