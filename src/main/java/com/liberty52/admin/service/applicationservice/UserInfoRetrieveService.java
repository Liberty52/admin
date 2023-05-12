package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.UserInfoListResponseDto;
import org.springframework.data.domain.Pageable;

public interface UserInfoRetrieveService {
    UserInfoListResponseDto retrieveAllByAdmin(String role, Pageable pageable);
}
