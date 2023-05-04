package com.liberty52.admin.global.exception.external.forbidden;

import com.liberty52.admin.global.exception.external.AbstractApiException;
import com.liberty52.admin.global.exception.external.AdminErrorCode;

public class ForbiddenException extends AbstractApiException {
    public ForbiddenException(String msg) {
        super(AdminErrorCode.FORBIDDEN, msg);
    }
}
