package cn.sparke.core.common.bean;

import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import org.springframework.http.HttpStatus;

/**
 * Created by zhangbowen on 2017/5/5.
 */
public class ResultError {
    private long timestamp;
    private int status;
    private String error;
    private String path;
    private int code;
    private String message;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private ResultError() {
        this.timestamp = System.currentTimeMillis();
        this.path = ContextUtils.getCurAuth().getUri();
    }

    public ResultError(int code, String message) {
        this();
        this.code = code;
        this.message = message;
    }

    public ResultError(StatusCode statusCode) {
        this();
        this.code = statusCode.getValue();
        this.message = statusCode.getDescription();
    }

    public ResultError(StatusCode statusCode, HttpStatus httpStatus) {
        this();
        this.code = statusCode.getValue();
        this.message = statusCode.getDescription();
        this.status = httpStatus.value();
        this.error = httpStatus.name();
    }
}
