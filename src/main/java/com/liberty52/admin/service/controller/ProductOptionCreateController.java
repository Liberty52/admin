package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.ProductOptionCreateService;
import com.liberty52.admin.service.controller.dto.CreateProductOptionRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductOptionCreateController {

    private final ProductOptionCreateService productOptionCreateService;

    @PostMapping("/productOption/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProductOption(@RequestHeader("LB-Role") String role,
                                    @Validated @RequestBody CreateProductOptionRequestDto dto, @PathVariable String productId) {
        productOptionCreateService.createProductOption(role, dto, productId);
    }
}
