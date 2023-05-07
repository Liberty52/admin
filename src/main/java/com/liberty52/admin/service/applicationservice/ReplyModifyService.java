package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.ReplyModifyRequestDto;

public interface ReplyModifyService {
    void modify(String adminId, String role, ReplyModifyRequestDto dto, String reviewId, String replyId);
}
