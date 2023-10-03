package com.liberty52.admin.service.applicationservice.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.service.applicationservice.LicenseImageCreateService;
import com.liberty52.admin.service.controller.dto.LicenseImageCreateDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LicenseImageCreateServiceImpl implements LicenseImageCreateService {
	private final ProductServiceClient productServiceClient;
	@Override
	public void createLicenseImageByAdmin(String role, LicenseImageCreateDto dto,
		MultipartFile productIntroductionImageFile) {
		productServiceClient.createLicenseImageByAdmin(role, dto, productIntroductionImageFile);
	}
}
