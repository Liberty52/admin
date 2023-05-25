package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.ReviewReplyModifyService;
import com.liberty52.admin.service.controller.dto.ReplyModifyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReviewReplyModifyController {

    private final ReviewReplyModifyService reviewReplyModifyService;


    @PutMapping("/reviews/{reviewId}/replies/{replyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyReviewReply(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                            @RequestHeader("LB-Role") String role,
                            @Validated @RequestBody ReplyModifyRequestDto dto,
                            @PathVariable String reviewId,
                            @PathVariable String replyId) {
        reviewReplyModifyService.modifyReviewReply(adminId, role, dto, reviewId, replyId);
    }

}
