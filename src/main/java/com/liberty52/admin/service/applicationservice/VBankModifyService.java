package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.dto.AdminVBankModify;

public interface VBankModifyService {
    AdminVBankModify.Response updateVBankByAdmin(String adminId, String role, String vBankId, AdminVBankModify.Request request);
}
