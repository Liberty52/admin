package com.liberty52.admin.global.adapter.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminCanceledOrderListResponse {

    private List<AdminCanceledOrderContent> orders;
    private Long currentPage;
    private Long startPage;
    private Long lastPage;
    private Long totalLastPage;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AdminCanceledOrderContent {
        private String orderId;
        private String orderNumber;
        private String productName;
        private String orderDate;
        private String customerName;
        private String orderStatus;
        private String reqAt;
        private String canceledAt;
        private String approvedAdminName;
    }
}
