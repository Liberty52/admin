package com.liberty52.admin.service.applicationservice;

import org.springframework.data.domain.Pageable;

public interface OrderRetrieveService {

    String retrieveOrders(String adminId, String role, Pageable pageable);

    String retrieveOrderDetail(String adminId, String role, String orderId);

}
