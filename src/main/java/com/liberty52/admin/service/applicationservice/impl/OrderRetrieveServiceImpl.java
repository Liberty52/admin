package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminCanceledOrderDetailResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminCanceledOrderListResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminOrderDetailRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminOrderListResponse;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.OrderRetrieveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderRetrieveServiceImpl implements OrderRetrieveService {

    private final ProductServiceClient productServiceClient;

    @Override
    public AdminOrderListResponse retrieveOrders(String adminId, String role, Pageable pageable) {
        AdminRoleUtils.checkRole(role);
        return productServiceClient.retrieveOrdersByAdmin(adminId, role, pageable);
    }

    @Override
    public AdminOrderDetailRetrieveResponse retrieveOrderDetail(String adminId, String role, String orderId) {
        AdminRoleUtils.checkRole(role);
        return productServiceClient.retrieveOrderDetailByAdmin(adminId, role, orderId);
    }

    @Override
    public AdminCanceledOrderListResponse retrieveCanceledOrder(String adminId, String role, Pageable pageable, String type) {
        AdminRoleUtils.checkRole(role);
        return productServiceClient.retrieveCanceledOrdersByAdmin(adminId, role, pageable, type);
    }

    @Override
    public AdminCanceledOrderDetailResponse retrieveCanceledOrderDetail(String adminId, String role, String orderId) {
        AdminRoleUtils.checkRole(role);
        return productServiceClient.retrieveCanceledOrderDetailByAdmin(adminId, role, orderId);
    }

}
