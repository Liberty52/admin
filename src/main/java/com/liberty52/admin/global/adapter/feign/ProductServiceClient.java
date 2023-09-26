package com.liberty52.admin.global.adapter.feign;

import com.liberty52.admin.global.adapter.feign.dto.*;
import com.liberty52.admin.global.config.FeignImageConfig;
import com.liberty52.admin.service.controller.dto.*;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(value = "product", primary = false, configuration = FeignImageConfig.class)
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

    @GetMapping("/admin/productOptionInfo/{productId}")
    @ResponseStatus(HttpStatus.OK)
    List<ProductOptionResponseDto> retrieveProductOptionInfoListByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String productId, @RequestParam boolean onSale);

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

    @PutMapping("/admin/optionDetailOnSale/{optionDetailId}")
    @ResponseStatus(HttpStatus.OK)
    void modifyOptionDetailOnSailStateByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String optionDetailId);

    @PutMapping("/admin/productOption/{productOptionId}")
    @ResponseStatus(HttpStatus.OK)
    void modifyProductOptionByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String productOptionId, @Validated @RequestBody ProductOptionModifyRequestDto dto);

    @PutMapping("/admin/productOptionOnSale/{productOptionId}")
    @ResponseStatus(HttpStatus.OK)
    void modifyProductOptionOnSailStateByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String productOptionId);

    /** 가상계좌 추가 */
    @PostMapping("/admin/vbanks")
    @ResponseStatus(HttpStatus.CREATED)
    AdminVBankCreate.Response createVBankByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                                 @RequestHeader("LB-Role") String role,
                                                 @RequestBody @Valid AdminVBankCreate.Request request);

    /** 가상계좌 리스트 조회 */
    @GetMapping("/vbanks")
    @ResponseStatus(HttpStatus.OK)
    AdminVBankRetrieve.ListResponse getVBankInfoList();

    /** 가상계좌 수정 */
    @PutMapping("/admin/vbanks/{vBankId}")
    @ResponseStatus(HttpStatus.OK)
    AdminVBankModify.Response updateVBankByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                                 @RequestHeader("LB-Role") String role,
                                                 @PathVariable String vBankId,
                                                 @RequestBody @Valid AdminVBankModify.Request request);

    /** 가상계좌 삭제 */
    @DeleteMapping("/admin/vbanks/{vBankId}")
    @ResponseStatus(HttpStatus.OK)
    void deleteVBankByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                            @RequestHeader("LB-Role") String role,
                            @PathVariable String vBankId);

    /** 배송비 조회 */
    @GetMapping("/options/delivery/fee")
    @ResponseStatus(HttpStatus.OK)
    AdminDeliveryOptionFeeRetrieve.Response getDefaultDeliveryFee();

    /** 배송비 수정 */
    @PatchMapping("/admin/options/delivery/fee")
    @ResponseStatus(HttpStatus.OK)
    AdminDeliveryOptionFeeModify.Response updateDefaultDeliveryFeeByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
                                                                          @RequestHeader("LB-Role") String role,
                                                                          @RequestBody @Valid AdminDeliveryOptionFeeModify.Request request);
    /** 제품 설명 추가*/
    @PostMapping(value = "/admin/product/{productId}/introduction", consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    void createProductIntroductionByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String productId,
		@RequestPart(value = "images",required = false) MultipartFile productIntroductionImageFile);
}
