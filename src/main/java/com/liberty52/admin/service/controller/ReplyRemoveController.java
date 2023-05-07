package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.ReplyRemoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReplyRemoveController {

    private final ReplyRemoveService replyRemoveService;

    @DeleteMapping("/reviews/replies/{replyId}")
    @ResponseStatus(HttpStatus.OK)
    public void replyRemove(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId, @RequestHeader("LB-Role") String role, @PathVariable String replyId) {

        replyRemoveService.removeReply(adminId, role ,replyId);
    }
}
