package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.NoticeDetailRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.NoticeRetrieveResponse;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.NoticeRetrieveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeRetrieveServiceImpl implements NoticeRetrieveService {

    private final AuthServiceClient authServiceClient;

    @Override
    public NoticeRetrieveResponse retrieveNotices(String role, Pageable pageable) {
        AdminRoleUtils.checkRole(role);
        return authServiceClient.retrieveNoticesByAdmin(role, pageable);
    }

    @Override
    public NoticeDetailRetrieveResponse retrieveNoticeDetail(String role, String noticeId) {
        AdminRoleUtils.checkRole(role);
        return authServiceClient.retrieveNoticeDetailByAdmin(role, noticeId);
    }
}
