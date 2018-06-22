package cn.sparke.core.common.bean;

import cn.sparke.core.common.constants.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by zhangbowen on 16-6-29.
 */
@SuppressWarnings("unchecked")
public class ResponseErrorEntity extends ResponseEntity {
    public ResponseErrorEntity(HttpStatus statusCode) {
        super(statusCode);
    }

    public ResponseErrorEntity(StatusCode body, HttpStatus status) {
        super(new ResultError(body, status), status);
    }

    public ResponseErrorEntity(ResultError resultError, HttpStatus status) {
        super(resultError, status);
    }
}
