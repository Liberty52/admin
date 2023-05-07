package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.exception.external.forbidden.InvalidRoleException;
import com.liberty52.admin.service.controller.dto.ReplyModifyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.liberty52.admin.global.constants.RoleConstants.ADMIN;
@Service
@Transactional
@RequiredArgsConstructor
public class ReplyModifyServiceImpl implements ReplyModifyService {
    private final ProductServiceClient productServiceClient;
    @Override
    public void modify(String adminId, String role, ReplyModifyRequestDto dto, String reviewId, String replyId) {
        if(!ADMIN.equals(role))
            throw new InvalidRoleException(role);
        productServiceClient.replyModify(adminId, role, dto, reviewId, replyId);
    }
}
