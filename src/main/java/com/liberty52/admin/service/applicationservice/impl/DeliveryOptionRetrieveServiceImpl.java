package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminDeliveryOptionFeeRetrieve;
import com.liberty52.admin.service.applicationservice.DeliveryOptionRetrieveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryOptionRetrieveServiceImpl implements DeliveryOptionRetrieveService {

    private final ProductServiceClient productServiceClient;

    @Override
    public AdminDeliveryOptionFeeRetrieve.Response getDefaultDeliveryFee() {
        return productServiceClient.getDefaultDeliveryFee();
    }
}
