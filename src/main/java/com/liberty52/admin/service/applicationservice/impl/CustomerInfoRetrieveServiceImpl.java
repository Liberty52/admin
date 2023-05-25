package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.CustomerInfoRetrieveService;
import com.liberty52.admin.service.controller.dto.CustomerInfoListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerInfoRetrieveServiceImpl implements CustomerInfoRetrieveService {
    private final AuthServiceClient authServiceClient;
    @Override
    public CustomerInfoListResponseDto retrieveCustomerInfo(String role, Pageable pageable) {
        AdminRoleUtils.checkRole(role);
        return authServiceClient.retrieveCustomerInfoByAdmin(role, pageable);
    }
}
