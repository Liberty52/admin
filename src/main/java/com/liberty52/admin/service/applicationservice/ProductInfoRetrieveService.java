package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.ProductOptionResponseDto;

import java.util.List;

public interface ProductInfoRetrieveService {
    List<ProductOptionResponseDto> retrieveProductOptionInfoList(String role, String productId);
}
