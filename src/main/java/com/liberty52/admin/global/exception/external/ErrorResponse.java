package com.liberty52.admin.global.exception.external;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {

    private String timeStamp;
    private HttpStatus httpStatus;
    private String errorCode;
    private String errorName;
    private String errorMessage;
    private String path;
    private ErrorResponse cause;

    public static ErrorResponse createErrorResponse(ErrorCode errorCode, String path) {
        return new ErrorResponse(LocalDateTime.now().toString(),errorCode.getHttpStatus(),errorCode.getErrorCode()
                , errorCode.getErrorName(), errorCode.getErrorMessage(),path);
    }

    private ErrorResponse(String timeStamp, HttpStatus httpStatus, String errorCode, String errorName, String errorMessage, String path) {
        this.timeStamp = timeStamp;
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorName = errorName;
        this.errorMessage = errorMessage;
        this.path = path;
    }

    public static ErrorResponse createErrorResponse(ErrorCode errorCode, String path, String causeError) {
        try {
            ErrorResponse cause = null;
            if (causeError != null && !causeError.isBlank()) {
                cause = new ObjectMapper().readValue(causeError, ErrorResponse.class);
            }
            return new ErrorResponse(LocalDateTime.now().toString(),errorCode.getHttpStatus(),errorCode.getErrorCode()
                    , errorCode.getErrorName(), errorCode.getErrorMessage(),path, cause);
        } catch (JsonProcessingException e) {
            return ErrorResponse.createErrorResponse(AdminErrorCode.INTERNAL_SERVER_ERROR, path);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "timeStamp=" + timeStamp +
                ", httpStatus=" + httpStatus +
                ", errorCode='" + errorCode + '\'' +
                ", errorName='" + errorName + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}