package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.CustomerInfoListResponseDto;
import org.springframework.data.domain.Pageable;

public interface CustomerInfoRetrieveService {
    CustomerInfoListResponseDto retrieveCustomerInfo(String role, Pageable pageable);
}
