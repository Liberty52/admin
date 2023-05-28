package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.VBankDeleteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VBankDeleteController {

    private final VBankDeleteService vBankDeleteService;

    @DeleteMapping("/product/vbanks/{vBankId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteVBankByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                   @RequestHeader("LB-Role") String role,
                                   @PathVariable String vBankId) {
        log.info("[LIB-LOG] {} admin request delete vbank. vbankId={}", adminId, vBankId);
        vBankDeleteService.deleteVBankByAdmin(adminId, role, vBankId);
    }

}
