package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.OrderRetrieveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(produces = "application/json; charset=UTF-8")
@RequiredArgsConstructor
public class OrderRetrieveController {

    private final OrderRetrieveService orderRetrieveService;

    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public String retrieveOrders(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
            @RequestHeader("LB-Role") String role,
            Pageable pageable
    ) {
        log.info("[LIB LOG] ADMIN {} request retrieve orders : page={}, size={}", adminId, pageable.getPageNumber(), pageable.getPageSize());
        return orderRetrieveService.retrieveOrders(adminId, role, pageable);
    }

    @GetMapping("/orders/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public String retrieveOrderDetail(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
            @RequestHeader("LB-Role") String role,
            @PathVariable String orderId
    ) {
        log.info("[LIB LOG] ADMIN {} request retrieve order detail : orderId={}", adminId, orderId);
        return orderRetrieveService.retrieveOrderDetail(adminId, role, orderId);
    }

}
