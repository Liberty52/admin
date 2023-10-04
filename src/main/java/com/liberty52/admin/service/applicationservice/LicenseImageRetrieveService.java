package com.liberty52.admin.service.applicationservice;

import java.util.List;

import com.liberty52.admin.service.controller.dto.LicenseImageRetrieveDto;

public interface LicenseImageRetrieveService {
	List<LicenseImageRetrieveDto> retrieveLicenseImageByAdmin(String role);
}
