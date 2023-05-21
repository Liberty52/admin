package com.liberty52.admin.service.controller;

import com.liberty52.admin.global.adapter.feign.dto.AdminVBankStatusModifyDto;
import com.liberty52.admin.service.applicationservice.OrderStatusModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderStatusModifyController {

  private final OrderStatusModifyService orderStatusModifyService;
  @PutMapping("/orders/{orderId}/status")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void modifyOrderStatus(
      @RequestHeader("LB-Role") String role, @PathVariable String orderId,
      @RequestParam String orderStatus) {
    orderStatusModifyService.modifyOrderStatus(role,orderId,orderStatus);
  }

  @PutMapping("/orders/{orderId}/vbank")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void modifyOrderStatusOfVBank(
      @RequestHeader("LB-Role") String role, @PathVariable String orderId,
      @Validated @RequestBody AdminVBankStatusModifyDto dto) {
    orderStatusModifyService.modifyOrderStatusOfVBank(role,orderId,dto);
  }

}
