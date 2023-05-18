package com.liberty52.admin.service.controller;

import com.liberty52.admin.global.adapter.feign.dto.AdminReviewDetailResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminReviewRetrieveResponse;
import com.liberty52.admin.service.applicationservice.ReviewRetrieveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReviewRetrieveController {
  private final ReviewRetrieveService reviewRetrieveService;

  @GetMapping("/reviews")
  ResponseEntity<AdminReviewRetrieveResponse> retrieveAllReviews(@RequestHeader("LB-Role") String role,
       Pageable pageable) {
    return reviewRetrieveService.retrieveAllReviews(role,pageable);
  }

  @GetMapping("/reviews/{reviewId}")
  ResponseEntity<AdminReviewDetailResponse> retrieveReviewDetail(@RequestHeader("LB-Role") String role,
      @PathVariable String reviewId) {
    return reviewRetrieveService.retrieveReviewDetail(role,reviewId);
  }
}