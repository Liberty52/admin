package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.NoticeModifyService;
import com.liberty52.admin.service.controller.dto.NoticeModifyRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class NoticeModifyController {
    private final NoticeModifyService noticeModifyService;

    @PutMapping("/notices/{noticeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyNotice(@RequestHeader("LB-Role") String role,
                             @PathVariable String noticeId,
                             @Validated @RequestBody NoticeModifyRequestDto dto) {
        log.info("[LIB LOG] ADMIN {} requests for modifying notice : noticeId={}", "?", noticeId);
        noticeModifyService.modifyNotice(role, noticeId, dto);
    }
}
