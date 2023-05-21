package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.CreateOptionDetailRequestDto;

public interface OptionDetailCreateService {
    void createOptionDetail(String role, CreateOptionDetailRequestDto dto, String optionId);
}
