package com.liberty52.admin.service.applicationservice.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.service.applicationservice.LicenseImageRetrieveService;
import com.liberty52.admin.service.controller.dto.LicenseImageRetrieveDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LicenseImageRetrieveServiceImpl implements LicenseImageRetrieveService {
	private final ProductServiceClient productServiceClient;
	@Override
	public List<LicenseImageRetrieveDto> retrieveLicenseImageByAdmin(String role) {
		return productServiceClient.retrieveLicenseImageByAdmin(role);
	}
}
