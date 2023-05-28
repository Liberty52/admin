package com.liberty52.admin.global.adapter.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AdminDeliveryOptionFeeRetrieve {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private String fee;
        private String feeUpdatedAt;
    }
}
