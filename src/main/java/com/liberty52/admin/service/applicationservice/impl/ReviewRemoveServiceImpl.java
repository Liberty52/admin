package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.ReviewRemoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class ReviewRemoveServiceImpl implements ReviewRemoveService {

    private final ProductServiceClient productServiceClient;

    @Override
    public void removeCustomerReview(String adminId, String role, String reviewId) {
        AdminRoleUtils.checkRole(role);
        productServiceClient.removeCustomerReviewByAdmin(adminId, role, reviewId);
    }
}
