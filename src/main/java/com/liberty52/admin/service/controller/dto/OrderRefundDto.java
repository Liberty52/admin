package com.liberty52.admin.service.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderRefundDto {

    @Getter
    @AllArgsConstructor
    public static class Request {
        @NotBlank
        private String orderId;
        @NotNull
        private Integer fee;
    }

}
