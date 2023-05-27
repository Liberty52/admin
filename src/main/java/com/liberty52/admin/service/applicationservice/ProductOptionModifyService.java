package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.ProductOptionModifyRequestDto;

public interface ProductOptionModifyService {

    void modifyProductOption(String role, String productOptionId, ProductOptionModifyRequestDto dto);

    void modifyProductOptionOnSailState(String role, String productOptionId);
}
