package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.QuestionReplyCreateRequestDto;

public interface QuestionReplyCreateService {
    void createQuestionReply(String adminId, String role, QuestionReplyCreateRequestDto dto);
}
