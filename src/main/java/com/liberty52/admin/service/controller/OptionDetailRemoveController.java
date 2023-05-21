package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.OptionDetailRemoveService;
import com.liberty52.admin.service.controller.dto.OptionDetailRemoveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class OptionDetailRemoveController {

    private final OptionDetailRemoveService optionDetailRemoveService;

    @DeleteMapping("/optionDetail/{optionDetailId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeOptionDetail(@RequestHeader("LB-Role") String role, @PathVariable String optionDetailId, @Validated @RequestBody OptionDetailRemoveRequestDto dto) {
        optionDetailRemoveService.removeOptionDetail(role, optionDetailId, dto);
    }
}
