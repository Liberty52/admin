package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminVBankRetrieve;
import com.liberty52.admin.service.applicationservice.VBankRetrieveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VBankRetrieveServiceImpl implements VBankRetrieveService {

    private final ProductServiceClient productServiceClient;

    @Override
    public AdminVBankRetrieve.ListResponse getVBankList() {
        return productServiceClient.getVBankInfoList();
    }
}
