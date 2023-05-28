package com.liberty52.admin.service.controller;

import com.liberty52.admin.global.adapter.feign.dto.AdminVBankCreate;
import com.liberty52.admin.service.applicationservice.VBankCreateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VBankCreateController {

    private final VBankCreateService vBankCreateService;

    @PostMapping("/product/vbanks")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminVBankCreate.Response createVBankByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                                        @RequestHeader("LB-Role") String role,
                                                        @RequestBody @Valid AdminVBankCreate.Request request) {
        log.info("[LIB-LOG] {} admin request create new Vbank resource. bank={}, account={}, holder={}",
                adminId, request.getBank(), request.getAccountNumber(), request.getHolder());
        return vBankCreateService.createVBankByAdmin(adminId, role, request);
    }

}
