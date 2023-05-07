package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.ReplyCreateService;
import com.liberty52.admin.service.applicationservice.ReplyModifyService;
import com.liberty52.admin.service.controller.dto.ReplyCreateRequestDto;
import com.liberty52.admin.service.controller.dto.ReplyModifyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReplyModifyController {

    private final ReplyModifyService replyModifyService;


    @PutMapping("/reviews/{reviewId}/replies/{replyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void replyModify(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                            @RequestHeader("LB-Role") String role,
                            @Validated @RequestBody ReplyModifyRequestDto dto,
                            @PathVariable String reviewId,
                            @PathVariable String replyId) {
        replyModifyService.modify(adminId, role, dto, reviewId, replyId);
    }

}
