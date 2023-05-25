package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.exception.external.forbidden.InvalidRoleException;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.QuestionReplyCreateService;
import com.liberty52.admin.service.controller.dto.QuestionReplyCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.liberty52.admin.global.constants.RoleConstants.ADMIN;

@Transactional
@RequiredArgsConstructor
@Service
public class QuestionReplyCreateServiceImpl implements QuestionReplyCreateService {

    private final AuthServiceClient authServiceClient;

    @Override
    public void createQuestionReply(String adminId, String role, QuestionReplyCreateRequestDto dto) {
        AdminRoleUtils.checkRole(role);
        authServiceClient.createQuestionReplyByAdmin(adminId, role, dto);
    }
}
