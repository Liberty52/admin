package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminReviewDetailResponse;
import com.liberty52.admin.global.adapter.feign.dto.AdminReviewRetrieveResponse;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.ReviewRetrieveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewRetrieveServiceImpl implements ReviewRetrieveService {
  private final ProductServiceClient productServiceClient;

  @Override
  public ResponseEntity<AdminReviewRetrieveResponse> retrieveAllReviews(String role, Pageable pageable) {
    AdminRoleUtils.checkRole(role);
    return productServiceClient.retrieveReviewByAdmin(role,pageable);
  }

  @Override
  public ResponseEntity<AdminReviewDetailResponse> retrieveReviewDetail(String role, String reviewId) {
    AdminRoleUtils.checkRole(role);
    return productServiceClient.retrieveReviewDetailByAdmin(role,reviewId);
  }
}