package com.liberty52.admin.service.controller;

import com.liberty52.admin.global.adapter.feign.dto.AdminDeliveryOptionFeeRetrieve;
import com.liberty52.admin.service.applicationservice.DeliveryOptionRetrieveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DeliveryOptionRetrieveController {

    private final DeliveryOptionRetrieveService deliveryOptionRetrieveService;

    @GetMapping("/product/options/delivery/fee")
    @ResponseStatus(HttpStatus.OK)
    public AdminDeliveryOptionFeeRetrieve.Response getDefaultDeliveryFee(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId) {
        log.info("[LIB-LOG] {} admin request retrieve default delivery fee.", adminId);
        return deliveryOptionRetrieveService.getDefaultDeliveryFee();
    }

}
