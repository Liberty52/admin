package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.NoticeCreateService;
import com.liberty52.admin.service.applicationservice.QuestionReplyCreateService;
import com.liberty52.admin.service.controller.dto.NoticeCreateRequestDto;
import com.liberty52.admin.service.controller.dto.QuestionReplyCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class NoticeCreateController {

    private final NoticeCreateService noticeCreateService;

    @PostMapping("/questionReplies")
    @ResponseStatus(HttpStatus.CREATED)
    public void createQuestion(@RequestHeader("LB-Role") String role, @Validated @RequestBody NoticeCreateRequestDto dto) {
        noticeCreateService.createNotice(role, dto);
    }
}
