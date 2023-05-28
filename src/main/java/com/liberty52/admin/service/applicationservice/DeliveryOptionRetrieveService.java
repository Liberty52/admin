package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.dto.AdminDeliveryOptionFeeRetrieve;

public interface DeliveryOptionRetrieveService {
    AdminDeliveryOptionFeeRetrieve.Response getDefaultDeliveryFee();
}
