package com.liberty52.admin.global.adapter.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfoDto {

    // card
    private String paidAt;
    private String cardName;
    private String cardNumber;
    private Integer cardQuota;

    // vbank
    private String vbankInfo;
    private String depositorBank;
    private String depositorName;
    private String depositorAccount;
    private Boolean isApplyCashReceipt;
    // vbank For Refund
    private String refundBank;
    private String refundHolder;
    private String refundAccount;
    private String refundPhoneNum;

}
