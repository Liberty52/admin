package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.ProductInfoRetrieveService;
import com.liberty52.admin.service.controller.dto.ProductInfoRetrieveResponseDto;
import com.liberty52.admin.service.controller.dto.ProductOptionResponseDto;
import com.liberty52.admin.service.controller.dto.RetrieveProductOptionRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductInfoRetrieveServiceImpl implements ProductInfoRetrieveService {

    private final ProductServiceClient productServiceClient;

    @Override
    public List<ProductOptionResponseDto> retrieveProductOptionInfoList(String role, String productId, boolean onSale) {
        AdminRoleUtils.checkRole(role);
        return productServiceClient.retrieveProductOptionInfoListByAdmin(role, productId, onSale);
    }

    @Override
    public List<ProductInfoRetrieveResponseDto> retrieveProductListByAdmin(String role) {
        AdminRoleUtils.checkRole(role);
        return productServiceClient.retrieveProductListByAdmin(role);
    }

    @Override
    public ProductInfoRetrieveResponseDto retrieveProductByAdmin(String role, String productId) {
        AdminRoleUtils.checkRole(role);
        return productServiceClient.retrieveProductByAdmin(role, productId);
    }
}
