package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.OptionDetailCreateService;
import com.liberty52.admin.service.controller.dto.CreateOptionDetailRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OptionDetailCreateServiceImpl implements OptionDetailCreateService {

    private final ProductServiceClient productServiceClient;

    @Override
    public void createOptionDetail(String role, CreateOptionDetailRequestDto dto, String optionId) {
        AdminRoleUtils.checkRole(role);
        productServiceClient.createOptionDetailByAdmin(role, dto, optionId);
    }
}
