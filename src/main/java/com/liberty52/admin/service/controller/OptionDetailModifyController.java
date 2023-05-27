package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.OptionDetailModifyService;
import com.liberty52.admin.service.controller.dto.OptionDetailModifyRequestDto;
import com.liberty52.admin.service.controller.dto.OptionDetailOnSailModifyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class OptionDetailModifyController {

    private final OptionDetailModifyService optionDetailModifyService;

    @PatchMapping("/optionDetail/{optionDetailId}")
    @ResponseStatus(HttpStatus.OK)
    public void modifyOptionDetail(@RequestHeader("LB-Role") String role, @PathVariable String optionDetailId, @Validated @RequestBody OptionDetailModifyRequestDto dto) {
        optionDetailModifyService.modifyOptionDetail(role, optionDetailId, dto);
    }

    @PutMapping("/optionDetail/{optionDetailId}")
    @ResponseStatus(HttpStatus.OK)
    public void modifyOptionDetailOnSailState(@RequestHeader("LB-Role") String role, @PathVariable String optionDetailId, @Validated @RequestBody OptionDetailOnSailModifyRequestDto dto) {
        optionDetailModifyService.modifyOptionDetailOnSailState(role, optionDetailId, dto);
    }
}
