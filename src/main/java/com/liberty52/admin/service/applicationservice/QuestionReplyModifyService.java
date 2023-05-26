package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.QuestionReplyModifyRequestDto;

public interface QuestionReplyModifyService {
    void modifyQuestionReply(QuestionReplyModifyRequestDto dto, String questionReplyId, String adminId, String role);
}
