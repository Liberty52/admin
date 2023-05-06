package com.liberty52.admin.service.applicationservice;

import static com.liberty52.admin.global.constants.RoleConstants.ADMIN;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminReviewRetrieveResponse;
import com.liberty52.admin.global.exception.external.forbidden.InvalidRoleException;
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
  public ResponseEntity<AdminReviewRetrieveResponse> retrieveReview(String role, String adminId, String productId,
      Pageable pageable, boolean photoFilter) {
    if(!ADMIN.equals(role))
      throw new InvalidRoleException(role);
    return productServiceClient.retrieveReview(adminId,productId,pageable,photoFilter);
  }
}