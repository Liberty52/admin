package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.ProductOptionModifyService;
import com.liberty52.admin.service.controller.dto.ProductOptionModifyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProductOptionModifyController {

    private final ProductOptionModifyService productOptionModifyService;

    @PutMapping("/productOption/{productOptionId}")
    @ResponseStatus(HttpStatus.OK)
    public void modifyProductOption(@RequestHeader("LB-Role") String role, @PathVariable String productOptionId, @Validated @RequestBody ProductOptionModifyRequestDto dto) {
        productOptionModifyService.modifyProductOption(role, productOptionId, dto);
    }

    @PutMapping("/productOptionOnSale/{productOptionId}")
    @ResponseStatus(HttpStatus.OK)
    public void modifyProductOptionOnSailState(@RequestHeader("LB-Role") String role, @PathVariable String productOptionId) {
        productOptionModifyService.modifyProductOptionOnSailState(role, productOptionId);
    }
}
