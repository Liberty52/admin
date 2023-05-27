package com.liberty52.admin.service.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOptionResponseDto {

    String optionId;
    String optionName;
    boolean require;
    boolean onSale;
    List<ProductOptionDetailResponseDto> optionDetailList;
}
