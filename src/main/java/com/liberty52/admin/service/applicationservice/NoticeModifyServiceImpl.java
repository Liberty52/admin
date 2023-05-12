package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.service.controller.dto.NoticeModifyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeModifyServiceImpl implements NoticeModifyService {
    private final AuthServiceClient authServiceClient;

    @Override
    public void modify(String role, String noticeId, NoticeModifyRequestDto dto) {
        authServiceClient.noticeModify(role, noticeId, dto);
    }
}
