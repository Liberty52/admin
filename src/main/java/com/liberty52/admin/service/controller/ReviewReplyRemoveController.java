package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.ReviewReplyRemoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewReplyRemoveController {

    private final ReviewReplyRemoveService reviewReplyRemoveService;

    @DeleteMapping("/reviews/replies/{replyId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeReviewReply(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId, @RequestHeader("LB-Role") String role, @PathVariable String replyId) {

        reviewReplyRemoveService.removeReviewReply(adminId, role ,replyId);
    }
}
