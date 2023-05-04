package com.liberty52.admin.global.exception.external.internalservererror;

import com.liberty52.admin.global.exception.external.AbstractApiException;
import com.liberty52.admin.global.exception.external.AdminErrorCode;

public class InternalServerErrorException extends AbstractApiException {
    public InternalServerErrorException(String msg) {
        super(AdminErrorCode.INTERNAL_SERVER_ERROR, msg);
    }
}
