package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.ProductInfoRetrieveResponseDto;

import java.util.List;

public interface ProductInfoRetrieveService {
    List<ProductInfoRetrieveResponseDto> retrieveProductInfoList(String role);

    ProductInfoRetrieveResponseDto retrieveProductInfo(String role, String productId);
}
