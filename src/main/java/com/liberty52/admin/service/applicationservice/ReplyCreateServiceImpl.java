package com.liberty52.admin.service.applicationservice;

import static com.liberty52.admin.global.constants.RoleConstants.ADMIN;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.exception.external.forbidden.InvalidRoleException;
import com.liberty52.admin.service.controller.dto.ReplyCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class ReplyCreateServiceImpl implements
        ReplyCreateService {

    private final ProductServiceClient productServiceClient;

    @Override
    public void createReply(ReplyCreateRequestDto dto, String reviewId, String adminId,
            String role) {
        if(!ADMIN.equals(role))
            throw new InvalidRoleException(role);
        productServiceClient.replyCreate(adminId,role,dto,reviewId);
    }
}
