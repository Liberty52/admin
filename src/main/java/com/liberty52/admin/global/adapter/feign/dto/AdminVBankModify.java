package com.liberty52.admin.global.adapter.feign.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AdminVBankModify {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        @NotBlank
        private String bank;
        @NotBlank
        private String accountNumber;
        @NotBlank
        private String holder;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String vbankId;
        private String bankOfVBank;
        private String accountNumber;
        private String holder;
        private String vbank;
        private String updatedAt;
    }

}