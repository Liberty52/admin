package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.ProductInfoRetrieveService;
import com.liberty52.admin.service.applicationservice.QuestionReplyCreateService;
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
}
