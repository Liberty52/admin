package com.liberty52.admin.service.controller;

import com.liberty52.admin.global.adapter.feign.dto.AdminVBankRetrieve;
import com.liberty52.admin.service.applicationservice.VBankRetrieveService;
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
public class VBankRetrieveController {

    private final VBankRetrieveService vBankRetrieveService;

    @GetMapping("/product/vbanks")
    @ResponseStatus(HttpStatus.OK)
    public AdminVBankRetrieve.ListResponse getVBankInfoList(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId) {
        log.info("[LIB-LOG] {} admin request retrieve vbank infos.", adminId);
        return vBankRetrieveService.getVBankList();
    }

}
