package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.exception.external.forbidden.InvalidRoleException;
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
        if(!ADMIN.equals(role)) {
            throw new InvalidRoleException(role);
        }
        authServiceClient.createQuestionReply(adminId, role, dto);
    }
}
