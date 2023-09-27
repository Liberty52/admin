package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.service.applicationservice.ProductIntroductionModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductIntroductionModifyServiceImpl implements ProductIntroductionModifyService {
    private final ProductServiceClient productServiceClient;
    @Override
    public void modifyProductIntroduction(String role, String productId, MultipartFile productIntroductionImageFile) {
        productServiceClient.modifyProductIntroductionByAdmin(role, productId, productIntroductionImageFile);
    }
}
