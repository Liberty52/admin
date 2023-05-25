package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminVBankStatusModifyDto;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.OrderStatusModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderStatusModifyServiceImpl implements OrderStatusModifyService {
  private final ProductServiceClient productServiceClient;
  @Override
  public void modifyOrderStatus(String role, String orderId, String orderStatus) {
    AdminRoleUtils.checkRole(role);
    productServiceClient.modifyOrderStatusByAdmin(role,orderId,orderStatus);
  }

  @Override
  public void modifyOrderStatusOfVBank(String role, String orderId, AdminVBankStatusModifyDto dto) {
    AdminRoleUtils.checkRole(role);
    productServiceClient.modifyOrderStatusOfVBankByAdmin(role,orderId,dto);
  }
}
