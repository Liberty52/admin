package com.liberty52.admin.global.exception.external.badrequest;

import com.liberty52.admin.global.exception.external.AbstractApiException;
import com.liberty52.admin.global.exception.external.AdminErrorCode;

public class BadRequestException extends AbstractApiException {
    public BadRequestException(String msg) {
        super(AdminErrorCode.BAD_REQUEST, msg);
    }
}
