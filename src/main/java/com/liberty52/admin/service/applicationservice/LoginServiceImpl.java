package com.liberty52.admin.service.applicationservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminLoginRequestDto;
import com.liberty52.admin.global.adapter.feign.dto.AdminLoginResponseDto;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.controller.dto.LoginRequestDto;
import com.liberty52.admin.service.controller.dto.LoginResponseDto;
import feign.Response;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final AuthServiceClient authServiceClient;

    @Override
    public LoginResponseDto login(LoginRequestDto requestDto, HttpServletResponse response) {
        Response res = authServiceClient.login(AdminLoginRequestDto.of(requestDto.getId(), requestDto.getPassword()));

        try {
            AdminLoginResponseDto loginUser = new ObjectMapper().readValue(res.body().asInputStream().readAllBytes(), AdminLoginResponseDto.class);

            AdminRoleUtils.checkRole(loginUser.getRole());

            this.addHeaders(res, response);

            return LoginResponseDto.of(loginUser.getName(), loginUser.getRole());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addHeaders(Response feignResponse, HttpServletResponse response) {
        final String HEADER_ACCESS = "access";
        final String HEADER_REFRESH = "refresh";
        String access = new ArrayList<>(feignResponse.headers().getOrDefault(HEADER_ACCESS, null)).get(0);
        String refresh = new ArrayList<>(feignResponse.headers().getOrDefault(HEADER_REFRESH, null)).get(0);

        if (access != null) {
            response.addHeader(HEADER_ACCESS, access);
        }
        if (refresh != null) {
            response.addHeader(HEADER_REFRESH, refresh);
        }
    }
}
