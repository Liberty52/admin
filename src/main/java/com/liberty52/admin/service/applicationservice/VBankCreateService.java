package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.dto.AdminVBankCreate;

public interface VBankCreateService {
    AdminVBankCreate.Response createVBankByAdmin(String adminId, String role, AdminVBankCreate.Request request);
}
