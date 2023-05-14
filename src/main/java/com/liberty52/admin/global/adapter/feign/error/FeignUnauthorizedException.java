package com.liberty52.admin.global.adapter.feign.error;

public class FeignUnauthorizedException extends Feign4xxException {
    public FeignUnauthorizedException(String causeError) {
        super(FeignErrorCode.UNAUTHORIZED, causeError);
    }
    public FeignUnauthorizedException() {
        super(FeignErrorCode.UNAUTHORIZED);
    }
}
