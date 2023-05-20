package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.ProductInfoRetrieveResponseDto;
import com.liberty52.admin.service.controller.dto.ProductOptionResponseDto;

import java.util.List;

public interface ProductInfoRetrieveService {

    List<ProductOptionResponseDto> retrieveProductOptionInfoList(String role, String productId);

    List<ProductInfoRetrieveResponseDto> retrieveProductListByAdmin(String role);

    ProductInfoRetrieveResponseDto retrieveProductByAdmin(String role, String productId);

}
