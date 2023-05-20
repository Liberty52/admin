package com.liberty52.admin.global.adapter.feign.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminOrderRefundDto {

    @Getter
    @AllArgsConstructor
    public static class Request {
        @NotBlank
        private String orderId;
        @NotNull
        private Integer fee;
        public static AdminOrderRefundDto.Request of(String orderId, Integer fee) {
            return new AdminOrderRefundDto.Request(orderId, fee);
        }
    }

}
