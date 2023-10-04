package com.liberty52.admin.service.applicationservice;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.liberty52.admin.service.controller.dto.LicenseImageCreateDto;

public interface LicenseImageCreateService {
	void createLicenseImageByAdmin(String role, LicenseImageCreateDto dto,
		MultipartFile productIntroductionImageFile) throws IOException;
}
