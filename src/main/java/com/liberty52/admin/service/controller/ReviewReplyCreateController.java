package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.ReviewReplyCreateService;
import com.liberty52.admin.service.controller.dto.ReplyCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReviewReplyCreateController {

    private final ReviewReplyCreateService reviewReplyCreateService;


    @PostMapping("/reviews/{reviewId}/replies")
    public ResponseEntity<Void> createReviewReply(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
            @RequestHeader("LB-Role") String role,
            @Validated @RequestBody ReplyCreateRequestDto dto, @PathVariable String reviewId) {
        reviewReplyCreateService.createReviewReply(dto,reviewId,adminId,role);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
