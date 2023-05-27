package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.ProductOptionCreateService;
import com.liberty52.admin.service.controller.dto.CreateProductOptionRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductOptionCreateServiceImpl implements ProductOptionCreateService {

    private final ProductServiceClient productServiceClient;

    @Override
    public void createProductOption(String role, CreateProductOptionRequestDto dto, String productId) {
        AdminRoleUtils.checkRole(role);
        productServiceClient.createProductOptionByAdmin(role, dto, productId);
    }
}
