package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminOrderRefundDto;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.OrderCancelService;
import com.liberty52.admin.service.controller.dto.OrderRefundDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCancelServiceImpl implements OrderCancelService {

    private final ProductServiceClient productServiceClient;

    @Override
    public void refundCustomerOrder(String adminId, String role, OrderRefundDto.Request request) {
        AdminRoleUtils.checkRole(role);

        AdminOrderRefundDto.Request requestDto = AdminOrderRefundDto.Request.of(request.getOrderId(), request.getFee());

        productServiceClient.refundCustomerOrderByAdmin(adminId, role, requestDto);
    }
}
