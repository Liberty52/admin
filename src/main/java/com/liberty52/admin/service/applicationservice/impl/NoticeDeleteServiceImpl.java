package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.NoticeDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeDeleteServiceImpl implements NoticeDeleteService {
  private final AuthServiceClient authServiceClient;
  @Override
  public void deleteNotice(String role, String noticeId) {
    AdminRoleUtils.checkRole(role);
    authServiceClient.deleteNoticeByAdmin(role,noticeId);
  }
}
