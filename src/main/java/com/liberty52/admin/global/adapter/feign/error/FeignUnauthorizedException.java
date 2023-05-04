package com.liberty52.admin.global.adapter.feign.error;

public class FeignUnauthorizedException extends FeignClientException {
    public FeignUnauthorizedException() {
        super(FeignErrorCode.UNAUTHORIZED);
    }
}
