package com.liberty52.admin.service.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateOptionDetailRequestDto {

    @NotBlank
    String name;

    @NotNull
    @Min(0)
    Integer price;

    @NotNull
    Boolean onSale;

}
