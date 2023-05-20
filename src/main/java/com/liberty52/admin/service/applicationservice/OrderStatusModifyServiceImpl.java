package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminVBankStatusModifyDto;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderStatusModifyServiceImpl implements OrderStatusModifyService{
  private final ProductServiceClient productServiceClient;
  @Override
  public void modifyOrderStatus(String role, String orderId, String orderStatus) {
    AdminRoleUtils.checkRole(role);
    productServiceClient.modifyOrderStatus(role,orderId,orderStatus);
  }

  @Override
  public void modifyOrderStatusOfVBank(String role, String orderId, AdminVBankStatusModifyDto dto) {
    AdminRoleUtils.checkRole(role);
    productServiceClient.modifyOrderStatusOfVBank(role,orderId,dto);
  }
}
