package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.exception.external.forbidden.InvalidRoleException;
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
        if(!ADMIN.equals(role)) {
            throw new InvalidRoleException(role);
        }

        authServiceClient.deleteQuestionReply(adminId, role, questionReplyId);
    }
}
