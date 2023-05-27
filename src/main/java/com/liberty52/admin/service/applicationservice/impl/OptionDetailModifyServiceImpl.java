package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.OptionDetailModifyService;
import com.liberty52.admin.service.controller.dto.OptionDetailModifyRequestDto;
import com.liberty52.admin.service.controller.dto.OptionDetailOnSailModifyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OptionDetailModifyServiceImpl implements OptionDetailModifyService {

    private final ProductServiceClient productServiceClient;

    @Override
    public void modifyOptionDetail(String role, String optionDetailId, OptionDetailModifyRequestDto dto) {
        AdminRoleUtils.checkRole(role);
        productServiceClient.modifyOptionDetailByAdmin(role, optionDetailId, dto);
    }

    @Override
    public void modifyOptionDetailOnSailState(String role, String optionDetailId, OptionDetailOnSailModifyRequestDto dto) {
        AdminRoleUtils.checkRole(role);
        productServiceClient.modifyOptionDetailOnSailStateByAdmin(role, optionDetailId, dto);
    }
}
