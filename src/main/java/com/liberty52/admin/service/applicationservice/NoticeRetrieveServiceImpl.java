package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.NoticeDetailRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.NoticeRetrieveResponse;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeRetrieveServiceImpl implements NoticeRetrieveService {

    private final AuthServiceClient authServiceClient;

    @Override
    public NoticeRetrieveResponse retrieveNotices(String role, Pageable pageable) {
        AdminRoleUtils.checkRole(role);
        return authServiceClient.retrieveNotices(role, pageable);
    }

    @Override
    public NoticeDetailRetrieveResponse retrieveNoticeDetail(String role, String noticeId) {
        AdminRoleUtils.checkRole(role);
        return authServiceClient.retrieveNoticeDetail(role, noticeId);
    }
}
