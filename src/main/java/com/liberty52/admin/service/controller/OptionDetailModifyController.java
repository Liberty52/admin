package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.OptionDetailModifyService;
import com.liberty52.admin.service.controller.dto.OptionDetailModifyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class OptionDetailModifyController {

    private final OptionDetailModifyService optionDetailModifyService;

    @PutMapping("/optionDetail/{optionDetailId}")
    @ResponseStatus(HttpStatus.OK)
    public void modifyOptionDetail(@RequestHeader("LB-Role") String role, @PathVariable String optionDetailId, @Validated @RequestBody OptionDetailModifyRequestDto dto) {
        optionDetailModifyService.modifyOptionDetail(role, optionDetailId, dto);
    }

    @PutMapping("/optionDetailOnSale/{optionDetailId}")
    @ResponseStatus(HttpStatus.OK)
    public void modifyOptionDetailOnSailState(@RequestHeader("LB-Role") String role, @PathVariable String optionDetailId) {
        optionDetailModifyService.modifyOptionDetailOnSailState(role, optionDetailId);
    }
}
