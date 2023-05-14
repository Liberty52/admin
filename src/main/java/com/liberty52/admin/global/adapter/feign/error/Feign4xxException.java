package com.liberty52.admin.global.adapter.feign.error;

public class Feign4xxException extends FeignClientException {
    public Feign4xxException(String causeError) {
        super(FeignErrorCode.ERROR_4XX, causeError);
    }

    public Feign4xxException(FeignErrorCode errorCode, String causeError) {
        super(errorCode, causeError);
    }
    public Feign4xxException(FeignErrorCode errorCode) {
        super(errorCode);
    }
}
