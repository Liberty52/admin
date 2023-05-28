package com.liberty52.admin.service.controller;

import com.liberty52.admin.global.adapter.feign.dto.AdminDeliveryOptionFeeModify;
import com.liberty52.admin.service.applicationservice.DeliveryOptionModifyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DeliveryOptionModifyController {

    private final DeliveryOptionModifyService deliveryOptionModifyService;

    @PatchMapping("/product/options/delivery/fee")
    @ResponseStatus(HttpStatus.OK)
    public AdminDeliveryOptionFeeModify.Response updateDefaultDeliveryFeeByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                                                                 @RequestHeader("LB-Role") String role,
                                                                                 @RequestBody @Valid AdminDeliveryOptionFeeModify.Request request) {
        log.info("[LIB-LOG] {} admin request modify default delivery fee to {}.", adminId, request.getFee());
        return deliveryOptionModifyService.updateDefaultDeliveryFeeByAdmin(adminId, role, request);
    }

}
