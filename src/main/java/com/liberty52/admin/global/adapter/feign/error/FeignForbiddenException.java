package com.liberty52.admin.global.adapter.feign.error;

public class FeignForbiddenException extends Feign4xxException {
    public FeignForbiddenException(String causeError) {
        super(FeignErrorCode.FORBIDDEN, causeError);
    }
}
