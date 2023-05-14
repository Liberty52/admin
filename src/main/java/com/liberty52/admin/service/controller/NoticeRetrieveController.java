package com.liberty52.admin.service.controller;

import com.liberty52.admin.global.adapter.feign.dto.NoticeDetailRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.NoticeRetrieveResponse;
import com.liberty52.admin.service.applicationservice.NoticeRetrieveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NoticeRetrieveController {

    private final NoticeRetrieveService noticeRetrieveService;

    @GetMapping("/admin/notices")
    @ResponseStatus(HttpStatus.OK)
    public NoticeRetrieveResponse retrieveNotices(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                                  @RequestHeader("LB-Role") String role,
                                                  Pageable pageable) {
        log.info("[LIB LOG] ADMIN {} request retrieve notices : page={}, size={}", adminId, pageable.getPageNumber(), pageable.getPageSize());
        return noticeRetrieveService.retrieveNotices(role, pageable);
    }

    @GetMapping("/admin/notices/{noticeId}")
    @ResponseStatus(HttpStatus.OK)
    public NoticeDetailRetrieveResponse retrieveNoticeDetail(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                                             @RequestHeader("LB-Role") String role,
                                                             @PathVariable String noticeId) {
        log.info("[LIB LOG] ADMIN {} request retrieve notice detail : noticeId={}", adminId, noticeId);
        return noticeRetrieveService.retrieveNoticeDetail(role, noticeId);
    }

}
