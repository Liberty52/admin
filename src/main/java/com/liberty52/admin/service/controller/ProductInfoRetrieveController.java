package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.ProductInfoRetrieveService;
import com.liberty52.admin.service.controller.dto.ProductInfoRetrieveResponseDto;
import com.liberty52.admin.service.controller.dto.ProductOptionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductInfoRetrieveController {

    private final ProductInfoRetrieveService productInfoRetrieveService;

    @GetMapping("/productOptionInfo/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductOptionResponseDto> retrieveProductOptionInfoList(@RequestHeader("LB-Role") String role, @PathVariable String productId) {
        return productInfoRetrieveService.retrieveProductOptionInfoList(role, productId);
    }

    @GetMapping("/productInfo")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductInfoRetrieveResponseDto> retrieveProductListByAdmin(@RequestHeader("LB-Role") String role) {
        return productInfoRetrieveService.retrieveProductListByAdmin(role);
    }

    @GetMapping("/productInfo/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductInfoRetrieveResponseDto retrieveProductByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String productId) {
        return productInfoRetrieveService.retrieveProductByAdmin(role, productId);
    }
}
