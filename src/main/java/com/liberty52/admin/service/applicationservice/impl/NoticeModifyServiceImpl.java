package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.NoticeModifyService;
import com.liberty52.admin.service.controller.dto.NoticeModifyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeModifyServiceImpl implements NoticeModifyService {
    private final AuthServiceClient authServiceClient;

    @Override
    public void modifyNotice(String role, String noticeId, NoticeModifyRequestDto dto) {
        AdminRoleUtils.checkRole(role);
        authServiceClient.modifyNoticeByAdmin(role, noticeId, dto);
    }
}
