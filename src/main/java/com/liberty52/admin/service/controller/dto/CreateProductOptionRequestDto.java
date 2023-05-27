package com.liberty52.admin.service.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateProductOptionRequestDto {

    @NotBlank
    String name;

    @NotNull
    Boolean require;

    @NotNull
    Boolean onSail;
}
