package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.LoginRequestDto;
import com.liberty52.admin.service.controller.dto.LoginResponseDto;
import jakarta.servlet.http.HttpServletResponse;

public interface LoginService {

    LoginResponseDto login(LoginRequestDto requestDto, HttpServletResponse response);

}
