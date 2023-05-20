package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.dto.AdminVBankStatusModifyDto;

public interface OrderStatusModifyService {

  void modifyOrderStatus(String role, String orderId, String orderStatus);

  void modifyOrderStatusOfVBank(String role, String orderId, AdminVBankStatusModifyDto dto);
}
