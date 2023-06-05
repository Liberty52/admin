package com.liberty52.admin.service.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequestDto {

    @NotBlank(message = "ID_IS_MANDATORY")
    private String email;
    @NotBlank(message = "PW_IS_MANDATORY")
    private String password;

    private Boolean isAutoLogin;

}
