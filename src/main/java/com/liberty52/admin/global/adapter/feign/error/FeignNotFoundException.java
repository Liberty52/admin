package com.liberty52.admin.global.adapter.feign.error;

public class FeignNotFoundException extends Feign4xxException {

    public FeignNotFoundException(String causeError) {
        super(FeignErrorCode.NOT_FOUND, causeError);
    }

}
