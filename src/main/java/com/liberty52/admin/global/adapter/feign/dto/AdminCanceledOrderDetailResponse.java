package com.liberty52.admin.global.adapter.feign.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminCanceledOrderDetailResponse {

    private AdminOrderDetailRetrieveResponse basicOrderDetail;
    private AdminCanceledOrderInfoResponse canceledInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AdminCanceledOrderInfoResponse {
        private String reason;
        private String reqAt;
        private String canceledAt;
        private Integer fee;
        private String approvedAdminName;
    }
}
