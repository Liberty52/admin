package com.liberty52.admin.service.applicationservice.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.service.applicationservice.LicenseImageCreateService;
import com.liberty52.admin.service.controller.dto.LicenseImageCreateDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LicenseImageCreateServiceImpl implements LicenseImageCreateService {
	private final ProductServiceClient productServiceClient;
	private final ObjectMapper objectMapper;

	@Override
	public void createLicenseImageByAdmin(String role, LicenseImageCreateDto dto,
		MultipartFile productIntroductionImageFile) throws JsonProcessingException {
		String dtoJson = objectMapper.writeValueAsString(dto);
		productServiceClient.createLicenseImageByAdmin(role, dtoJson, productIntroductionImageFile);
	}
}
