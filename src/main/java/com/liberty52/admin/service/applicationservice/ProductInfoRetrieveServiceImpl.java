package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.exception.external.forbidden.InvalidRoleException;
import com.liberty52.admin.service.controller.dto.ProductInfoRetrieveResponseDto;
import com.liberty52.admin.service.controller.dto.ProductOptionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.liberty52.admin.global.constants.RoleConstants.ADMIN;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductInfoRetrieveServiceImpl implements ProductInfoRetrieveService {

    private final ProductServiceClient productServiceClient;

    @Override
    public List<ProductOptionResponseDto> retrieveProductOptionInfoList(String role, String productId) {
        if (!ADMIN.equals(role)) {
            throw new InvalidRoleException(role);
        }
        return productServiceClient.retrieveProductOptionInfoList(productId);
    }

    @Override
    public List<ProductInfoRetrieveResponseDto> retrieveProductListByAdmin(String role) {
        if(!ADMIN.equals(role)) {
            throw new InvalidRoleException(role);
        }
        return productServiceClient.retrieveProductListByAdmin(role);
    }

    @Override
    public ProductInfoRetrieveResponseDto retrieveProductByAdmin(String role, String productId) {
        if(!ADMIN.equals(role)) {
            throw new InvalidRoleException(role);
        }
        return productServiceClient.retrieveProductByAdmin(role, productId);
    }
}