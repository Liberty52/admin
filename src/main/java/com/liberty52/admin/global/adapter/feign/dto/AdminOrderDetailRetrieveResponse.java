package com.liberty52.admin.global.adapter.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminOrderDetailRetrieveResponse {

    private String orderId;
    private String orderDate;
    private String orderStatus;
    private String address;
    private String receiverEmail;
    private String receiverName;
    private String receiverPhoneNumber;
    private String productRepresentUrl;
    private long totalProductPrice;
    private int deliveryFee;
    private long totalPrice;
    private String orderNum;
    private String paymentType;
    private PaymentInfoDto paymentInfo;
    private List<AdminOrderRetrieveProductResponse> products;
    private String customerName;

}
