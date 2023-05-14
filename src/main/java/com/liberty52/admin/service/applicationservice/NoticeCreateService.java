package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.NoticeCreateRequestDto;

public interface NoticeCreateService {
    void createNotice(String role, NoticeCreateRequestDto dto);
}
