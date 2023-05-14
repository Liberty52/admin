package com.liberty52.admin.service.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserInfoResponseDto {
    private String id;
    private String name;
    private String email;
    private String profileUrl;
    private String phoneNumber;
    private LocalDate createdAt;
    private String role;
}

