package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminLoginRequestDto;
import com.liberty52.admin.global.adapter.feign.dto.AdminLoginResponseDto;
import com.liberty52.admin.global.exception.external.internalservererror.InternalServerErrorException;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.controller.dto.LoginRequestDto;
import com.liberty52.admin.service.controller.dto.LoginResponseDto;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final AuthServiceClient authServiceClient;

    @Override
    public LoginResponseDto login(LoginRequestDto requestDto, HttpServletResponse response) {
        ResponseEntity<AdminLoginResponseDto> feignResponse = authServiceClient.login(AdminLoginRequestDto.of(requestDto.getId(), requestDto.getPassword()));
        AdminLoginResponseDto user = feignResponse.getBody();

        assertNotNull(requestDto, user);
        AdminRoleUtils.checkRole(user.getRole());

        this.addHeaders(feignResponse, response);
        return LoginResponseDto.of(feignResponse.getBody().getName(), feignResponse.getBody().getRole());
    }

    private void assertNotNull(LoginRequestDto requestDto, AdminLoginResponseDto user) {
        if (user == null) {
            log.error("Received null that user response of AUTH server during login. Request ID={}", requestDto.getId());
            throw new InternalServerErrorException("로그인 과정에서 오류가 발생하였습니다. 시스템 관리자에게 문의해주세요.");
        }
    }

    private void addHeaders(ResponseEntity<?> feignResponse, HttpServletResponse response) {
        final String HEADER_ACCESS = "access";
        final String HEADER_REFRESH = "refresh";
        String accessToken = feignResponse.getHeaders().getOrDefault(HEADER_ACCESS, null).get(0);
        String refreshToken = feignResponse.getHeaders().getOrDefault(HEADER_REFRESH, null).get(0);
        if (accessToken != null) {
            response.addHeader(HEADER_ACCESS, accessToken);
        }
        if (refreshToken != null) {
            response.addHeader(HEADER_REFRESH,  refreshToken);
        }
    }

}
