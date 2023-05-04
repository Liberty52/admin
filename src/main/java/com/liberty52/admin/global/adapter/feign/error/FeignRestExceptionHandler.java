package com.liberty52.admin.global.adapter.feign.error;

import com.liberty52.admin.global.exception.external.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FeignRestExceptionHandler {

    @ExceptionHandler(FeignClientException.class)
    public ResponseEntity<ErrorResponse> handleFeignClientException(FeignClientException ex, HttpServletRequest request) {
        return ResponseEntity.status(ex.getHttpStatus())
                .body(ErrorResponse.createErrorResponse(ex, request.getRequestURI()));
    }

}
