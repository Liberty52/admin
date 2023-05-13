package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.UserInfoRetrieveService;
import com.liberty52.admin.service.controller.dto.UserInfoListResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserInfoRetrieveController {
    private final UserInfoRetrieveService userInfoRetrieveService;

    @GetMapping("/user-info")
    @ResponseStatus(HttpStatus.OK)
    public UserInfoListResponseDto userInfoListByAdmin(@RequestHeader("LB-Role") String role,
                                                       Pageable pageable) {
        log.info("[LIB LOG] ADMIN {} requests for retrieving user information", "?");
        return userInfoRetrieveService.retrieveAllByAdmin(role, pageable);
    }
}
