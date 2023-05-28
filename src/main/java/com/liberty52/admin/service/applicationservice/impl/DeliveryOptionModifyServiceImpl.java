package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminDeliveryOptionFeeModify;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.DeliveryOptionModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryOptionModifyServiceImpl implements DeliveryOptionModifyService {

    private final ProductServiceClient productServiceClient;

    @Override
    public AdminDeliveryOptionFeeModify.Response updateDefaultDeliveryFeeByAdmin(String adminId,
                                                                                 String role,
                                                                                 AdminDeliveryOptionFeeModify.Request request) {
        AdminRoleUtils.checkRole(role);
        return productServiceClient.updateDefaultDeliveryFeeByAdmin(adminId, role, request);
    }
}
