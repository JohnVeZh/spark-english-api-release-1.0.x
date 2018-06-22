package cn.sparke.common.interceotor;

import cn.sparke.common.annot.NoNeedActive;
import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.ResultError;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.gift.modules.v1.activationCode.mapper.ActivationCodeMapper;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Ning
 * 2017/8/25.
 */
public class ActiveInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        ActivationCodeMapper activationCodeMapper = factory.getBean(ActivationCodeMapper.class);

        if (handler instanceof HandlerMethod) {
            AuthEntity curAuth = ContextUtils.getCurAuth();
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            NoNeedActive annotation = handlerMethod.getMethodAnnotation(NoNeedActive.class);
            NoNeedActive activeAnnotClassAnnot = handlerMethod.getBeanType().getAnnotation(NoNeedActive.class);
            if ((annotation == null && activeAnnotClassAnnot == null)) {//需要验证权限并且上面验证的结果为错误
                //处理验证结果，如果用户没有激活，返回没有激活
                int result = activationCodeMapper.isActivated(curAuth.getUserId(), curAuth.getSectionCode());
                if (result <= 0) {//没有激活
                    response.setCharacterEncoding("UTF-8");
                    ResultError resultMsg = new ResultError(StatusCode.ACTIVATION_CODE_NOT_BE_ACTIVATED);
                    response.setStatus(HttpStatus.BAD_REQUEST.value());
                    PrintWriter out = response.getWriter();
                    out.print(JSON.toJSONString(resultMsg));
                    out.flush();
                    out.close();
                    return false;
                } else {//激活
                    return true;
                }

            }
        }
        return true;
    }


}
