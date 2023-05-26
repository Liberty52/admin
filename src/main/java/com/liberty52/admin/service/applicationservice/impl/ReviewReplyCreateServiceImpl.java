package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.ReviewReplyCreateService;
import com.liberty52.admin.service.controller.dto.ReplyCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class ReviewReplyCreateServiceImpl implements
    ReviewReplyCreateService {

    private final ProductServiceClient productServiceClient;

    @Override
    public void createReviewReply(ReplyCreateRequestDto dto, String reviewId, String adminId,
            String role) {
        AdminRoleUtils.checkRole(role);
        productServiceClient.createReviewReplyByAdmin(adminId,role,dto,reviewId);
    }
}
