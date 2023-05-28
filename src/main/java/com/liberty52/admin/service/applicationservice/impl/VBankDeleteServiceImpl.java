package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.VBankDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VBankDeleteServiceImpl implements VBankDeleteService {

    private final ProductServiceClient productServiceClient;

    @Override
    public void deleteVBankByAdmin(String adminId, String role, String vBankId) {
        AdminRoleUtils.checkRole(role);
        productServiceClient.deleteVBankByAdmin(adminId, role, vBankId);
    }
}
