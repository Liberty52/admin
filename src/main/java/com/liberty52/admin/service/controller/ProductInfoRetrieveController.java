package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.ProductInfoRetrieveService;
import com.liberty52.admin.service.controller.dto.ProductInfoRetrieveResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductInfoRetrieveController {
    private final ProductInfoRetrieveService productInfoRetrieveService;

    @GetMapping("/productInfo")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductInfoRetrieveResponseDto> retrieveProductInfoList(@RequestHeader("LB-Role") String role) {
        return productInfoRetrieveService.retrieveProductInfoList(role);
    }

    @GetMapping("/productInfo/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductInfoRetrieveResponseDto retrieveProductInfo(@RequestHeader("LB-Role") String role, @PathVariable String productId) {
        return productInfoRetrieveService.retrieveProductInfo(role, productId);
    }
}
