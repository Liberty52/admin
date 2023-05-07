package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class ReviewRemoveServiceImpl implements ReviewRemoveService {

    private final AuthServiceClient authServiceClient;

    @Override
    public void removeCustomerReview(String adminId, String role, String reviewId) {
        authServiceClient.removeCustomerReview(adminId, role, reviewId);
    }
}
