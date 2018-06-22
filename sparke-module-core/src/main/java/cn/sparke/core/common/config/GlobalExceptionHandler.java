package cn.sparke.core.common.config;

import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.bean.ResultError;
import cn.sparke.core.common.constants.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangbowen on 2017/6/6.
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Object MethodArgumentNotValidHandler(HttpServletRequest request,
                                                MethodArgumentNotValidException exception) throws Exception {

        FieldError fieldError = exception.getBindingResult().getFieldError();
        ResultError resultMsg = new ResultError(StatusCode.VALIDATION_FAILED.getValue(), fieldError.getField() + fieldError.getDefaultMessage());
        return new ResponseErrorEntity(resultMsg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public Object handleBindException(BindException exception) {
        FieldError fieldError = exception.getBindingResult().getFieldError();
        ResultError resultMsg = new ResultError(StatusCode.VALIDATION_FAILED.getValue(), fieldError.getField() + fieldError.getDefaultMessage());
        return new ResponseErrorEntity(resultMsg, HttpStatus.BAD_REQUEST);
    }
}
