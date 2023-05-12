package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.controller.dto.UserInfoListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoRetrieveServiceImpl implements UserInfoRetrieveService {
    private final AuthServiceClient authServiceClient;
    @Override
    public UserInfoListResponseDto retrieveAllByAdmin(String role, Pageable pageable) {
        AdminRoleUtils.checkRole(role);
        return authServiceClient.userInfoListByAdmin(role, pageable);
    }
}
