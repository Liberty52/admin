package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.NoticeModifyRequestDto;

public interface NoticeModifyService {
    void modifyNotice(String role, String noticeId, NoticeModifyRequestDto dto);
}
