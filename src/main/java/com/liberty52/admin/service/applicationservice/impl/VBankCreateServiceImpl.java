package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminVBankCreate;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.VBankCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VBankCreateServiceImpl implements VBankCreateService {

    private final ProductServiceClient productServiceClient;

    @Override
    public AdminVBankCreate.Response createVBankByAdmin(String adminId, String role, AdminVBankCreate.Request request) {
        AdminRoleUtils.checkRole(role);
        return productServiceClient.createVBankByAdmin(adminId, role, request);
    }
}
