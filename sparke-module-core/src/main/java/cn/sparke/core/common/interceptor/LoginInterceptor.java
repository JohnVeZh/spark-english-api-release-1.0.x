package cn.sparke.core.common.interceptor;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.core.modules.cache.CacheFacade;
import cn.sparke.core.modules.token.utils.TokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangbowen on 2017/5/6.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            AuthEntity curAuth = ContextUtils.getCurAuth();
            //获取header中的相应验证信息
            int terminal = curAuth.getTerminal();
            String tokenStr = curAuth.getToken();
            String userId = curAuth.getUserId();
            //获取token后缀
            String suffix = TokenUtils.getSuffix(terminal);
            //验证请求头中的用户id和token是否匹配
            boolean success = this.checkToken(suffix, userId, tokenStr);
            //重置请求头中的token，保证真实有效
            if (!success) {
                curAuth.setUserId(null);
                curAuth.setToken(null);
                ContextUtils.setCurAuth(curAuth);
            }
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            LoginAnnot annotation = handlerMethod.getMethodAnnotation(LoginAnnot.class);
            LoginAnnot loginClassAnnot = handlerMethod.getBeanType().getAnnotation(LoginAnnot.class);
            //如果请求的接口需要验证token
            if ((annotation != null || loginClassAnnot != null) && !success) {//需要验证权限并且上面验证的结果为错误
                //处理验证结果，返回没有权限
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return false;
            }
        }
        return true;
    }

    /**
     * 验证token
     *
     * @param suffix
     * @param userId
     * @param token
     * @return
     */
    private boolean checkToken(String suffix, String userId, String token) {
        if (userId == null || token == null || suffix == null) {
            return false;
        }
        String cachedToken = CacheFacade.getObject(userId + suffix);
        return null != cachedToken && cachedToken.equals(token);
    }


}
