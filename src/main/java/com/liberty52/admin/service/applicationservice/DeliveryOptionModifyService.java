package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.dto.AdminDeliveryOptionFeeModify;

public interface DeliveryOptionModifyService {
    AdminDeliveryOptionFeeModify.Response updateDefaultDeliveryFeeByAdmin(String adminId,
                                                                          String role,
                                                                          AdminDeliveryOptionFeeModify.Request request);
}
