package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.CreateProductOptionRequestDto;

public interface ProductOptionCreateService {
    void createProductOption(String role, CreateProductOptionRequestDto dto, String productId);
}
