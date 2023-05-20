package com.liberty52.admin.global.adapter.feign;

import com.liberty52.admin.global.adapter.feign.dto.AdminReviewDetailResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminReviewRetrieveResponse;
import com.liberty52.admin.service.controller.dto.CreateOptionDetailRequestDto;
import com.liberty52.admin.service.controller.dto.ReplyCreateRequestDto;
import com.liberty52.admin.service.controller.dto.ReplyModifyRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "product", primary = false)
public interface ProductServiceClient {
    @PostMapping("/reviews/{reviewId}/replies")
    void replyCreate(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
        @RequestHeader("LB-Role") String role,
        @Validated @RequestBody ReplyCreateRequestDto dto, @PathVariable String reviewId) ;

    @PutMapping("/reviews/{reviewId}/replies/{replyId}")
    void replyModify(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                            @RequestHeader("LB-Role") String role,
                            @Validated @RequestBody ReplyModifyRequestDto dto,
                            @PathVariable String reviewId,
                            @PathVariable String replyId);
    @GetMapping("/admin/reviews")
    ResponseEntity<AdminReviewRetrieveResponse> retrieveAllReviews(@RequestHeader("LB-Role") String role, Pageable pageable);

    @GetMapping("/admin/reviews/{reviewId}")
    ResponseEntity<AdminReviewDetailResponse> retrieveReviewDetail(@RequestHeader("LB-Role") String role, @PathVariable String reviewId);

    @DeleteMapping("/customerReviews/{reviewId}")
    @ResponseStatus(HttpStatus.OK)
    void removeCustomerReview(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId, @RequestHeader("LB-Role") String role, @PathVariable String reviewId);

    @DeleteMapping("/reviews/replies/{replyId}")
    @ResponseStatus(HttpStatus.OK)
    void removeReply(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId, @RequestHeader("LB-Role") String role, @PathVariable String replyId);

    @GetMapping("/admin/orders")
    @ResponseStatus(HttpStatus.OK)
    String retrieveOrders(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
            @RequestHeader("LB-Role") String role,
            Pageable pageable
    );

    @GetMapping("/admin/orders/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    String retrieveOrderDetail(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
            @RequestHeader("LB-Role") String role,
            @PathVariable String orderId
    );

    @PostMapping("/optionDetail/{optionId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOptionDetail(@RequestHeader("LB-Role") String role,
                                   @Validated @RequestBody CreateOptionDetailRequestDto dto, @PathVariable String optionId);
}
