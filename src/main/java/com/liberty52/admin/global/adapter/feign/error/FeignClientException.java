package com.liberty52.admin.global.adapter.feign.error;

import com.liberty52.admin.global.exception.external.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FeignClientException extends RuntimeException implements ErrorCode {

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorName;
    private final String errorMessage;
    private final String causeError;

    public FeignClientException(FeignErrorCode code, String causeError) {
        this.httpStatus = code.getHttpStatus();
        this.errorCode = code.getErrorCode();
        this.errorName = code.getErrorName();
        this.errorMessage = code.getErrorMessage();
        this.causeError = causeError;
    }

    public FeignClientException(String causeError) {
        this(FeignErrorCode.ERROR_UNKNOWN, causeError);
    }
}
