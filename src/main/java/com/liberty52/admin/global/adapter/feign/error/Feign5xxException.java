package com.liberty52.admin.global.adapter.feign.error;

public class Feign5xxException extends FeignClientException {
    public Feign5xxException() {
        super(FeignErrorCode.ERROR_5XX);
    }
}
