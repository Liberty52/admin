package com.liberty52.admin.global.adapter.feign;

import com.liberty52.admin.service.controller.dto.ReplyCreateRequestDto;
import com.liberty52.admin.service.controller.dto.ReplyModifyRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "product", primary = false)
public interface ProductServiceClient {


    @PostMapping("/reviews/{reviewId}/replies")
    void replyCreate(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
            @RequestHeader("X-ROLE") String role,
            @Validated @RequestBody ReplyCreateRequestDto dto, @PathVariable String reviewId) ;

    @PutMapping("/reviews/{reviewId}/replies/{replyId}")
    @ResponseStatus(HttpStatus.CREATED)
    void replyModify(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                            @RequestHeader("LB-Role") String role,
                            @Validated @RequestBody ReplyModifyRequestDto dto,
                            @PathVariable String reviewId,
                            @PathVariable String replyId);
}
