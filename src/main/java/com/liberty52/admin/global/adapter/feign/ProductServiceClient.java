package com.liberty52.admin.global.adapter.feign;

import com.liberty52.admin.global.adapter.feign.dto.AdminReviewDetailResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminReviewRetrieveResponse;
import com.liberty52.admin.service.controller.dto.CreateOptionDetailRequestDto;
import com.liberty52.admin.global.adapter.feign.dto.*;
import com.liberty52.admin.service.controller.dto.ProductInfoRetrieveResponseDto;
import com.liberty52.admin.service.controller.dto.ProductOptionResponseDto;
import com.liberty52.admin.service.controller.dto.ReplyCreateRequestDto;
import com.liberty52.admin.service.controller.dto.ReplyModifyRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    AdminOrderListResponse retrieveOrders(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                          @RequestHeader("LB-Role") String role,
                          Pageable pageable);

    @PostMapping("/optionDetail/{optionId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOptionDetail(@RequestHeader("LB-Role") String role,
                                   @Validated @RequestBody CreateOptionDetailRequestDto dto, @PathVariable String optionId);

    @GetMapping("/admin/orders/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    AdminOrderDetailRetrieveResponse retrieveOrderDetail(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                                         @RequestHeader("LB-Role") String role,
                                                         @PathVariable String orderId);

    @PostMapping("/orders/refund")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void refundCustomerOrder(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                             @RequestHeader("LB-Role") String role,
                             @RequestBody AdminOrderRefundDto.Request request);
    @PatchMapping("/admin/orders/{orderId}/status")
    @ResponseStatus(HttpStatus.OK)
    void modifyOrderStatus(@RequestHeader("LB-Role") String role, @PathVariable String orderId,
        @RequestParam String orderStatus);

    @PatchMapping("/admin/orders/{orderId}/vbank")
    @ResponseStatus(HttpStatus.OK)
    void modifyOrderStatusOfVBank(@RequestHeader("LB-Role") String role, @PathVariable String orderId,
        @Validated @RequestBody AdminVBankStatusModifyDto dto);

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

    @GetMapping("/productOptionInfo/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductOptionResponseDto> retrieveProductOptionInfoList(@PathVariable String productId);

    @GetMapping("/productInfo")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductInfoRetrieveResponseDto> retrieveProductListByAdmin(@RequestHeader("LB-Role") String role);

    @GetMapping("/productInfo/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductInfoRetrieveResponseDto retrieveProductByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String productId);

}
