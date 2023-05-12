package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.LoginService;
import com.liberty52.admin.service.controller.dto.LoginRequestDto;
import com.liberty52.admin.service.controller.dto.LoginResponseDto;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponseDto login(
            @RequestBody @Validated LoginRequestDto dto,
            HttpServletResponse response
    ) {
        return loginService.login(dto, response);
    }

}
