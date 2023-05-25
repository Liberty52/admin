package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.QuestionReplyModifyService;
import com.liberty52.admin.service.controller.dto.QuestionReplyModifyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class QuestionReplyModifyController {

    private final QuestionReplyModifyService questionReplyModifyService;


    @PutMapping("/questionReplies/{questionReplyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyQuestionReply(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
            @RequestHeader("LB-Role") String role,
            @Validated @RequestBody QuestionReplyModifyRequestDto dto, @PathVariable String questionReplyId) {
        questionReplyModifyService.modifyQuestionReply(dto,questionReplyId,adminId,role);
    }

}
