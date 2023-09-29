package com.liberty52.admin.service.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOptionDetailResponseDto {

    String optionDetailId;
    String optionDetailName;
    int price;
    boolean onSale;
    int stock;

}
