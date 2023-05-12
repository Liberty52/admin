package com.liberty52.admin.global.adapter.feign.error;

public class Feign5xxException extends FeignClientException {
    public Feign5xxException(String causeError) {
        super(FeignErrorCode.ERROR_5XX, causeError);
    }
}
