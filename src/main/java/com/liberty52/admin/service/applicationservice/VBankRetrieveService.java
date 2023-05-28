package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.dto.AdminVBankRetrieve;

public interface VBankRetrieveService {
    AdminVBankRetrieve.ListResponse getVBankList();
}
