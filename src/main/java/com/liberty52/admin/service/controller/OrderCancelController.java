package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.OrderCancelService;
import com.liberty52.admin.service.controller.dto.OrderRefundDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderCancelController {

    private final OrderCancelService orderCancelService;

    @PostMapping("/orders/refund")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void refundCustomerOrder(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                    @RequestHeader("LB-Role") String role,
                                    @RequestBody @Validated OrderRefundDto.Request request) {
        log.info("[LIB LOG] ADMIN {} request refund order for canceled : orderId={}", adminId, request.getOrderId());
        orderCancelService.refundCustomerOrder(adminId, role, request);
    }

}
