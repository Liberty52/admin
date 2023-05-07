package com.liberty52.admin.global.utils;

import static com.liberty52.admin.global.constants.RoleConstants.ADMIN;

import com.liberty52.admin.global.exception.external.forbidden.InvalidRoleException;

public class AdminRoleUtils {
    public static void checkRole(String role) {
      if(!ADMIN.equals(role)){
        throw new InvalidRoleException(role);
      }
    }
  }
