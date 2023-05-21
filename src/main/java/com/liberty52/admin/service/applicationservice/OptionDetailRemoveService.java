package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.OptionDetailRemoveRequestDto;

public interface OptionDetailRemoveService {
    void removeOptionDetail(String role, String optionDetailId, OptionDetailRemoveRequestDto dto);
}
