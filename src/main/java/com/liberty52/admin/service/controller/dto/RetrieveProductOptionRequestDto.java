package com.liberty52.admin.service.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RetrieveProductOptionRequestDto {

    @NotNull
    Boolean onSale;
}
