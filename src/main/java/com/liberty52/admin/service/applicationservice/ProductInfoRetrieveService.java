package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.ProductInfoRetrieveResponseDto;

import java.util.List;

public interface ProductInfoRetrieveService {
    List<ProductInfoRetrieveResponseDto> retrieveProductListByAdmin(String role);

    ProductInfoRetrieveResponseDto retrieveProductByAdmin(String role, String productId);
}
