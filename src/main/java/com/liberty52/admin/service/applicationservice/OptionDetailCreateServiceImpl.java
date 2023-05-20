package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
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
        productServiceClient.createOptionDetail(role, dto, optionId);
    }
}
