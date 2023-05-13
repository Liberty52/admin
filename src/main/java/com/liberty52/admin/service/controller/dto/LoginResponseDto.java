package com.liberty52.admin.service.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseDto {

    private String name;
    private String role;

    public static LoginResponseDto of(String name, String role) {
        return new LoginResponseDto(name, role);
    }
}
