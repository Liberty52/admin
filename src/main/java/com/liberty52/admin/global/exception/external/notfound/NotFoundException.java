package com.liberty52.admin.global.exception.external.notfound;

import com.liberty52.admin.global.exception.external.AbstractApiException;
import com.liberty52.admin.global.exception.external.AdminErrorCode;

public class NotFoundException extends AbstractApiException {
    public NotFoundException(String msg) {
        super(AdminErrorCode.NOT_FOUND, msg);
    }
}
