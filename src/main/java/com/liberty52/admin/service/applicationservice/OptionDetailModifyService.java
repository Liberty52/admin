package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.service.controller.dto.OptionDetailModifyRequestDto;
import com.liberty52.admin.service.controller.dto.OptionDetailOnSailModifyRequestDto;

public interface OptionDetailModifyService {

    void modifyOptionDetail(String role, String optionDetailId, OptionDetailModifyRequestDto dto);

    void modifyOptionDetailOnSailState(String role, String optionDetailId, OptionDetailOnSailModifyRequestDto dto);
}
