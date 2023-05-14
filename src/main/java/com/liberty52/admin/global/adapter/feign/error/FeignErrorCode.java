package com.liberty52.admin.global.adapter.feign.error;

import com.liberty52.admin.global.exception.external.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum FeignErrorCode implements ErrorCode {

    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "FEIGN_ERROR - 로그인이 안 되어있거나 실패하였습니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "FEIGN_ERROR - 접근할 권한이 없습니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "FEIGN_ERROR - 잘못된 요청입니다."),
    ERROR_4XX(HttpStatus.INTERNAL_SERVER_ERROR),
    ERROR_5XX(HttpStatus.INTERNAL_SERVER_ERROR),
    ERROR_UNKNOWN(HttpStatus.INTERNAL_SERVER_ERROR)
    ;

    private static final String DEFAULT_MESSAGE = "시스템에 오류가 발생하였습니다. 관리자에게 문의해주세요.";
    private final HttpStatus httpStatus;
    private final String errorMessage;
    private final String errorCode = "AF-" + "0".repeat(Math.max(4-String.valueOf(this.ordinal() + 1).length(), 0)) + (this.ordinal() + 1);

    FeignErrorCode(HttpStatus httpStatus, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    FeignErrorCode(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.errorMessage = DEFAULT_MESSAGE;
    }

    public String getErrorName() {
        return this.name();
    }


}
