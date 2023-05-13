package com.liberty52.admin.global.utils;

import com.liberty52.admin.global.exception.external.forbidden.InvalidRoleException;

import static com.liberty52.admin.global.constants.RoleConstants.ADMIN;

public class AdminRoleUtils {
    public static void checkRole(String role) {
        if (!ADMIN.equals(role)) {
            throw new InvalidRoleException(role);
        }
    }
}
