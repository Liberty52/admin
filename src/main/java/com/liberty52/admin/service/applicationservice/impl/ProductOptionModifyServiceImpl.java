package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.ProductOptionModifyService;
import com.liberty52.admin.service.controller.dto.ProductOptionModifyRequestDto;
import com.liberty52.admin.service.controller.dto.ProductOptionOnSailModifyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductOptionModifyServiceImpl implements ProductOptionModifyService {

    private final ProductServiceClient productServiceClient;

    @Override
    public void modifyProductOption(String role, String productOptionId, ProductOptionModifyRequestDto dto) {
        AdminRoleUtils.checkRole(role);
        productServiceClient.modifyProductOptionByAdmin(role, productOptionId, dto);

    }

    @Override
    public void modifyProductOptionOnSailState(String role, String productOptionId, ProductOptionOnSailModifyRequestDto dto) {
        AdminRoleUtils.checkRole(role);
        productServiceClient.modifyProductOptionOnSailStateByAdmin(role, productOptionId, dto);
    }
}
