package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.controller.dto.OptionDetailRemoveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class OptionDetailRemoveServiceImpl implements OptionDetailRemoveService {

    private final ProductServiceClient productServiceClient;

    @Override
    public void removeOptionDetail(String role, String optionDetailId, OptionDetailRemoveRequestDto dto) {
        AdminRoleUtils.checkRole(role);
        productServiceClient.removeOptionDetail(role,optionDetailId,dto);
    }
}
