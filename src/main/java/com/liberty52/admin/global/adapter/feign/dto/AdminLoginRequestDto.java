package com.liberty52.admin.global.adapter.feign.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminLoginRequestDto {

    @NotBlank(message = "LOGIN_EMAIL_IS_MANDATORY")
    private String email;
    @NotBlank(message = "LOGIN_PW_IS_MANDATORY")
    private String password;

    public static AdminLoginRequestDto of(String email, String password) {
        return new AdminLoginRequestDto(email, password);
    }

}