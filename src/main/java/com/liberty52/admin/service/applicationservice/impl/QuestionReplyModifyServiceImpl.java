package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.exception.external.forbidden.InvalidRoleException;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.QuestionReplyModifyService;
import com.liberty52.admin.service.controller.dto.QuestionReplyModifyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.liberty52.admin.global.constants.RoleConstants.ADMIN;

@Transactional
@RequiredArgsConstructor
@Service
public class QuestionReplyModifyServiceImpl implements QuestionReplyModifyService {
    private final AuthServiceClient authServiceClient;
    @Override
    public void modifyQuestionReply(QuestionReplyModifyRequestDto dto, String questionReplyId, String adminId, String role) {
        AdminRoleUtils.checkRole(role);
        authServiceClient.modifyQuestionReplyByAdmin(adminId, role, dto, questionReplyId);
    }
}
