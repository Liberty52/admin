package com.liberty52.admin.global.adapter.feign.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class PaymentInfoDto {

    @NoArgsConstructor
    @AllArgsConstructor
    public static class CardPaymentInfo extends PaymentInfoDto {
        private String paidAt;
        private String cardName;
        private String cardNumber;
        private Integer cardQuota;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    public static class VBankPaymentInfo extends PaymentInfoDto {
        private String vbankInfo;
        private String depositorBank;
        private String depositorName;
        private String depositorAccount;
        private Boolean isApplyCashReceipt;
        private String paidAt;

        // For Refund
        private String refundBank;
        private String refundHolder;
        private String refundAccount;
        private String refundPhoneNum;
    }



}
