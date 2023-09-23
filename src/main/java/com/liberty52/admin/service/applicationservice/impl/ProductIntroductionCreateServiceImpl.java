package com.liberty52.admin.service.applicationservice.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.liberty52.admin.global.adapter.feign.ProductServiceClient;
import com.liberty52.admin.service.applicationservice.ProductIntroductionCreateService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductIntroductionCreateServiceImpl implements ProductIntroductionCreateService {
	private final ProductServiceClient productServiceClient;
	@Override
	public void createProductIntroduction(String role, String productId, MultipartFile productIntroductionImageFile) {
		productServiceClient.createProductIntroductionByAdmin(role, productId, productIntroductionImageFile);
	}
}
