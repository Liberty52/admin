package com.liberty52.admin.global.adapter.feign;

import com.liberty52.admin.global.adapter.feign.dto.*;
import com.liberty52.admin.service.controller.dto.ReplyCreateRequestDto;
import com.liberty52.admin.service.controller.dto.ReplyModifyRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    String retrieveOrders(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                          @RequestHeader("LB-Role") String role,
                          Pageable pageable);

    @GetMapping("/admin/orders/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    String retrieveOrderDetail(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                               @RequestHeader("LB-Role") String role,
                               @PathVariable String orderId);

    @PostMapping("/orders/refund")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void refundCustomerOrder(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                             @RequestHeader("LB-Role") String role,
                             @RequestBody AdminOrderRefundDto.Request request);

    @GetMapping("/admin/orders/cancel")
    @ResponseStatus(HttpStatus.OK)
    AdminCanceledOrderListResponse retrieveCanceledOrders(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                                          @RequestHeader("LB-Role") String role,
                                                          Pageable pageable,
                                                          @RequestParam(value = "type", required = false) String type);

    @GetMapping("/admin/orders/cancel/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    AdminCanceledOrderDetailResponse retrieveCanceledOrderDetail(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                                                 @RequestHeader("LB-Role") String role,
                                                                 @PathVariable String orderId);

}
