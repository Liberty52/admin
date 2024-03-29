package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.dto.AdminCanceledOrderDetailResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminCanceledOrderListResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminOrderDetailRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminOrderListResponse;
import org.springframework.data.domain.Pageable;

public interface OrderRetrieveService {

    AdminOrderListResponse retrieveOrders(String adminId, String role, Pageable pageable);

    AdminOrderDetailRetrieveResponse retrieveOrderDetail(String adminId, String role, String orderId);

    AdminCanceledOrderListResponse retrieveCanceledOrder(String adminId, String role, Pageable pageable, String type);

    AdminCanceledOrderDetailResponse retrieveCanceledOrderDetail(String adminId, String role, String orderId);

}
