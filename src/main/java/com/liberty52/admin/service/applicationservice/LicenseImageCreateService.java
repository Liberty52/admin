package com.liberty52.admin.service.applicationservice;

import org.springframework.web.multipart.MultipartFile;

import com.liberty52.admin.service.controller.dto.LicenseImageCreateDto;

public interface LicenseImageCreateService {
	void createLicenseImageByAdmin(String role, LicenseImageCreateDto dto, MultipartFile productIntroductionImageFile);
}
