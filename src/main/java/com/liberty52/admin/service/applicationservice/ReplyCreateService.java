package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.ReplyCreateRequestDto;

public interface ReplyCreateService {

    void createReply(ReplyCreateRequestDto dto, String reviewId, String adminId, String role);

}
