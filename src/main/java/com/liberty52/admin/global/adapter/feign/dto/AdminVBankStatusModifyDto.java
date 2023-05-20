package com.liberty52.admin.global.adapter.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminVBankStatusModifyDto {
  private String depositorBank;
  private String depositorName;
  private String depositorAccount;

}
