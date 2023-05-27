package com.liberty52.admin.global.adapter.feign;

import com.liberty52.admin.global.adapter.feign.dto.AdminCanceledOrderDetailResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminCanceledOrderListResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminOrderDetailRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminOrderListResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminOrderRefundDto;
import com.liberty52.admin.global.adapter.feign.dto.AdminReviewDetailResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminReviewRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminVBankStatusModifyDto;
import com.liberty52.admin.service.controller.dto.*;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "product", primary = false)
public interface ProductServiceClient {
    @PostMapping("/admin/reviews/{reviewId}/replies")
    void createReviewReplyByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
        @RequestHeader("LB-Role") String role,
        @Validated @RequestBody ReplyCreateRequestDto dto, @PathVariable String reviewId) ;

    @PutMapping("/admin/reviews/{reviewId}/replies/{replyId}")
    void modifyReviewReplyByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                            @RequestHeader("LB-Role") String role,
                            @Validated @RequestBody ReplyModifyRequestDto dto,
                            @PathVariable String reviewId,
                            @PathVariable String replyId);
    @GetMapping("/admin/reviews")
    ResponseEntity<AdminReviewRetrieveResponse> retrieveReviewByAdmin(@RequestHeader("LB-Role") String role, Pageable pageable);

    @GetMapping("/admin/reviews/{reviewId}")
    ResponseEntity<AdminReviewDetailResponse> retrieveReviewDetailByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String reviewId);

    @DeleteMapping("/admin/customerReviews/{reviewId}")
    @ResponseStatus(HttpStatus.OK)
    void removeCustomerReviewByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId, @RequestHeader("LB-Role") String role, @PathVariable String reviewId);

    @DeleteMapping("/admin/reviews/replies/{replyId}")
    @ResponseStatus(HttpStatus.OK)
    void removeReplyByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId, @RequestHeader("LB-Role") String role, @PathVariable String replyId);

    @GetMapping("/admin/orders")
    @ResponseStatus(HttpStatus.OK)
    AdminOrderListResponse retrieveOrdersByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                          @RequestHeader("LB-Role") String role,
                          Pageable pageable);

    @PostMapping("/admin/optionDetail/{optionId}")
    @ResponseStatus(HttpStatus.CREATED)
    void createOptionDetailByAdmin(@RequestHeader("LB-Role") String role,
                                   @Validated @RequestBody CreateOptionDetailRequestDto dto, @PathVariable String optionId);

    @GetMapping("/admin/orders/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    AdminOrderDetailRetrieveResponse retrieveOrderDetailByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                                         @RequestHeader("LB-Role") String role,
                                                         @PathVariable String orderId);

    @PostMapping("/admin/orders/refund")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void refundCustomerOrderByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                             @RequestHeader("LB-Role") String role,
                             @RequestBody AdminOrderRefundDto.Request request);
    @PutMapping("/admin/orders/{orderId}/status")
    @ResponseStatus(HttpStatus.OK)
    void modifyOrderStatusByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String orderId,
        @RequestParam String orderStatus);

    @PutMapping("/admin/orders/{orderId}/vbank")
    @ResponseStatus(HttpStatus.OK)
    void modifyOrderStatusOfVBankByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String orderId,
        @Validated @RequestBody AdminVBankStatusModifyDto dto);

    @GetMapping("/admin/orders/cancel")
    @ResponseStatus(HttpStatus.OK)
    AdminCanceledOrderListResponse retrieveCanceledOrdersByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                                          @RequestHeader("LB-Role") String role,
                                                          Pageable pageable,
                                                          @RequestParam(value = "type", required = false) String type);

    @GetMapping("/admin/orders/cancel/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    AdminCanceledOrderDetailResponse retrieveCanceledOrderDetailByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                                                 @RequestHeader("LB-Role") String role,
                                                                 @PathVariable String orderId);

    @GetMapping("/productOptionInfo/{productId}")
    @ResponseStatus(HttpStatus.OK)
    List<ProductOptionResponseDto> retrieveProductOptionInfoList(@PathVariable String productId);

    @GetMapping("/admin/productInfo")
    @ResponseStatus(HttpStatus.OK)
    List<ProductInfoRetrieveResponseDto> retrieveProductListByAdmin(@RequestHeader("LB-Role") String role);

    @GetMapping("/admin/productInfo/{productId}")
    @ResponseStatus(HttpStatus.OK)
    ProductInfoRetrieveResponseDto retrieveProductByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String productId);

    @PutMapping("/admin/optionDetail/{optionDetailId}")
    @ResponseStatus(HttpStatus.OK)
    void modifyOptionDetailByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String optionDetailId, @Validated @RequestBody OptionDetailModifyRequestDto dto);

    @PostMapping("/admin/productOption/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    void createProductOptionByAdmin(@RequestHeader("LB-Role") String role,
                                          @Validated @RequestBody CreateProductOptionRequestDto dto, @PathVariable String productId);

    @PatchMapping("/admin/optionDetail/{optionDetailId}")
    @ResponseStatus(HttpStatus.OK)
    void modifyOptionDetailOnSailStateByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String optionDetailId, @Validated @RequestBody OptionDetailOnSailModifyRequestDto dto);

    @PutMapping("/admin/productOption/{productOptionId}")
    @ResponseStatus(HttpStatus.OK)
    void modifyProductOptionByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String productOptionId, @Validated @RequestBody ProductOptionModifyRequestDto dto);

    @PatchMapping("/admin/productOption/{productOptionId}")
    @ResponseStatus(HttpStatus.OK)
    void modifyProductOptionOnSailStateByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String productOptionId, @Validated @RequestBody ProductOptionOnSailModifyRequestDto dto);

}
