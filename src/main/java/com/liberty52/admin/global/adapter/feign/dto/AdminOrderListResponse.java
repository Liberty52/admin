package com.liberty52.admin.global.adapter.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminOrderListResponse {
    private List<AdminOrderContent> orders;
    private Long currentPage;
    private Long startPage;
    private Long lastPage;
    private Long totalLastPage;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AdminOrderContent {
        private String orderId;
        private String orderNumber;
        private String productName;
        private String orderDate;
        private String customerName;
        private String orderStatus;
    }
}
