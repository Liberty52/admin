package com.liberty52.admin.service.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class OptionDetailRemoveRequestDto {
    @NotNull
    Boolean onSail;
}
