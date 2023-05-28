package com.liberty52.admin.service.controller;

import com.liberty52.admin.global.adapter.feign.dto.AdminVBankModify;
import com.liberty52.admin.service.applicationservice.VBankModifyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VBankModifyController {

    private final VBankModifyService vBankModifyService;

    @PutMapping("/product/vbanks/{vBankId}")
    @ResponseStatus(HttpStatus.OK)
    public AdminVBankModify.Response updateVBankByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                                        @RequestHeader("LB-Role") String role,
                                                        @PathVariable String vBankId,
                                                        @RequestBody @Valid AdminVBankModify.Request request) {
        log.info("[LIB-LOG] {} admin request modify vbank info. bank={}, account={}, holder={}",
                adminId, request.getBank(), request.getAccountNumber(), request.getHolder());
        return vBankModifyService.updateVBankByAdmin(adminId, role, vBankId, request);
    }
}
