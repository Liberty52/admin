package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.ReviewReplyModifyService;
import com.liberty52.admin.service.controller.dto.ReplyModifyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewReplyModifyServiceImpl implements ReviewReplyModifyService {
    private final ProductServiceClient productServiceClient;
    @Override
    public void modifyReviewReply(String adminId, String role, ReplyModifyRequestDto dto, String reviewId, String replyId) {
        AdminRoleUtils.checkRole(role);
        productServiceClient.modifyReviewReplyByAdmin(adminId, role, dto, reviewId, replyId);
    }
}
