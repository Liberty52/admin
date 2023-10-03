package com.liberty52.admin.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.liberty52.admin.service.applicationservice.LicenseImageCreateService;
import com.liberty52.admin.service.controller.dto.LicenseImageCreateDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LicenseImageCreateController {
	private final LicenseImageCreateService licenseImageCreateService;

	@PostMapping("/licenseImage")
	@ResponseStatus(HttpStatus.CREATED)
	public void createLicenseImageByAdmin(@RequestHeader("LB-Role") String role,
		@Validated @RequestPart("dto") LicenseImageCreateDto dto,
		@RequestPart(value = "images", required = false) MultipartFile productIntroductionImageFile) {
		licenseImageCreateService.createLicenseImageByAdmin(role, dto, productIntroductionImageFile);
	}
}
