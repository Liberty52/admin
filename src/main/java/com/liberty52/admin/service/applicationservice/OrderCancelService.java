package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.OrderRefundDto;

public interface OrderCancelService {

    void refundCustomerOrder(String adminId, String role, OrderRefundDto.Request request);

}
