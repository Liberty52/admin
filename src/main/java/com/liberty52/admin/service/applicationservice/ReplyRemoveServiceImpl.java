package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.exception.external.forbidden.InvalidRoleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.liberty52.admin.global.constants.RoleConstants.ADMIN;

@Transactional
@RequiredArgsConstructor
@Service
public class ReplyRemoveServiceImpl implements ReplyRemoveService {
    private final ProductServiceClient productServiceClient;

    @Override
    public void removeReply(String adminId, String role, String replyId) {
        if(!ADMIN.equals(role)) {
            throw new InvalidRoleException(role);
        }
        productServiceClient.removeReply(adminId, role ,replyId);
    }
}
