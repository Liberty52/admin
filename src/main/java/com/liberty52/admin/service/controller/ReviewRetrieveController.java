package com.liberty52.admin.service.controller;

import com.liberty52.admin.global.adapter.feign.dto.AdminReviewRetrieveResponse;
import com.liberty52.admin.service.applicationservice.ReviewRetrieveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReviewRetrieveController {
  private final ReviewRetrieveService reviewRetrieveService;

  @GetMapping("/reviews/products/{productId}")
  ResponseEntity<AdminReviewRetrieveResponse> retrieveReview(@RequestHeader("X-ROLE") String role,
      @RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String adminId,
      @PathVariable String productId, Pageable pageable,
      @RequestParam(required = false) boolean photoFilter) {
    return reviewRetrieveService.retrieveReview(role,adminId,productId,pageable,photoFilter);
  }

}