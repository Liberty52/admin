package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.dto.AdminReviewRetrieveResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ReviewRetrieveService {
  ResponseEntity<AdminReviewRetrieveResponse> retrieveReview(String role,String adminId,String productId,
      Pageable pageable,boolean photoFilter);
}