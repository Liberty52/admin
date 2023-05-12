package com.liberty52.admin.global.adapter.feign.error;

public class FeignBadRequestException extends Feign4xxException {
    public FeignBadRequestException(String causeError) {
        super(FeignErrorCode.BAD_REQUEST, causeError);
    }
}
