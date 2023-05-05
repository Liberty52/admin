package com.liberty52.admin.global.adapter.feign;

import com.liberty52.admin.service.controller.dto.ReplyCreateRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(value = "product", primary = false)
public interface ProductServiceClient {


    @PostMapping("/reviews/{reviewId}/replies")
    void replyCreate(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
            @RequestHeader("X-ROLE") String role,
            @Validated @RequestBody ReplyCreateRequestDto dto, @PathVariable String reviewId) ;

}
