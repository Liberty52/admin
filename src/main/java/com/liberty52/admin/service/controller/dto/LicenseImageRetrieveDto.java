package com.liberty52.admin.service.controller.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LicenseImageRetrieveDto {
	private String id;
	private String artistName;
	private String artName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String licenseImageUrl;
	private Integer stock;

}
