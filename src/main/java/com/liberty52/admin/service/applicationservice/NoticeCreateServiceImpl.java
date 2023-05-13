package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.controller.dto.NoticeCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeCreateServiceImpl implements NoticeCreateService {

    private final AuthServiceClient authServiceClient;

    @Override
    public void createNotice(String role, NoticeCreateRequestDto dto) {
        AdminRoleUtils.checkRole(role);
        authServiceClient.createNotice(role, dto);
    }
}
