package com.liberty52.admin.global.adapter.feign.error;

public class Feign4xxException extends FeignClientException {
    public Feign4xxException() {
        super(FeignErrorCode.ERROR_4XX);
    }
}
