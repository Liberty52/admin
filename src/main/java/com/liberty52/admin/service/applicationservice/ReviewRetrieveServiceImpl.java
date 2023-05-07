package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminReviewRetrieveResponse;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class ReviewRetrieveServiceImpl implements ReviewRetrieveService{
  private final ProductServiceClient productServiceClient;

  @Override
  public ResponseEntity<AdminReviewRetrieveResponse> retrieveAllReviews(String role, Pageable pageable) {
    AdminRoleUtils.checkRole(role);
    return productServiceClient.retrieveAllReviews(role,pageable);
  }
}