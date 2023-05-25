package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.exception.external.forbidden.InvalidRoleException;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.QuestionReplyDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.liberty52.admin.global.constants.RoleConstants.ADMIN;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionReplyDeleteServiceImpl implements QuestionReplyDeleteService {

    private final AuthServiceClient authServiceClient;

    @Override
    public void deleteQuestionReply(String adminId, String role, String questionReplyId) {
        AdminRoleUtils.checkRole(role);
        authServiceClient.deleteQuestionReplyByAdmin(adminId, role, questionReplyId);
    }
}
