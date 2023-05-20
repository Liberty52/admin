package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminCanceledOrderDetailResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminCanceledOrderListResponse;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderRetrieveServiceImpl implements OrderRetrieveService {

    private final ProductServiceClient productServiceClient;

    @Override
    public String retrieveOrders(String adminId, String role, Pageable pageable) {
        AdminRoleUtils.checkRole(role);
        return productServiceClient.retrieveOrders(adminId, role, pageable);
    }

    @Override
    public String retrieveOrderDetail(String adminId, String role, String orderId) {
        AdminRoleUtils.checkRole(role);
        return productServiceClient.retrieveOrderDetail(adminId, role, orderId);
    }

    @Override
    public AdminCanceledOrderListResponse retrieveCanceledOrder(String adminId, String role, Pageable pageable, String type) {
        AdminRoleUtils.checkRole(role);
        return productServiceClient.retrieveCanceledOrders(adminId, role, pageable, type);
    }

    @Override
    public AdminCanceledOrderDetailResponse retrieveCanceledOrderDetail(String adminId, String role, String orderId) {
        AdminRoleUtils.checkRole(role);
        return productServiceClient.retrieveCanceledOrderDetail(adminId, role, orderId);
    }

}
