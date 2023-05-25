package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.ReviewReplyRemoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class ReviewReplyRemoveServiceImpl implements ReviewReplyRemoveService {
    private final ProductServiceClient productServiceClient;

    @Override
    public void removeReviewReply(String adminId, String role, String replyId) {
        AdminRoleUtils.checkRole(role);
        productServiceClient.removeReplyByAdmin(adminId, role ,replyId);
    }
}
