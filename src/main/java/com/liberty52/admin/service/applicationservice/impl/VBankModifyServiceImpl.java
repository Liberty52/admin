package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminVBankModify;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.VBankModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VBankModifyServiceImpl implements VBankModifyService {

    private final ProductServiceClient productServiceClient;

    @Override
    public AdminVBankModify.Response updateVBankByAdmin(String adminId, String role, String vBankId, AdminVBankModify.Request request) {
        AdminRoleUtils.checkRole(role);
        return productServiceClient.updateVBankByAdmin(adminId, role, vBankId, request);
    }
}
