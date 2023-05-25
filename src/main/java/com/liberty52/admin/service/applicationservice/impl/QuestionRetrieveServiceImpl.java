package com.liberty52.admin.service.applicationservice.impl;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminQuestionRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.QuestionDetailResponseDto;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import com.liberty52.admin.service.applicationservice.QuestionRetrieveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class QuestionRetrieveServiceImpl implements QuestionRetrieveService {

  private final AuthServiceClient authServiceClient;
  @Override
  public ResponseEntity<AdminQuestionRetrieveResponse> retrieveAllQuestions(String role,
      int pageNumber, int size) {
    AdminRoleUtils.checkRole(role);
    return authServiceClient.retrieveQuestionByAdmin(role,pageNumber,size);
  }

  @Override
  public ResponseEntity<QuestionDetailResponseDto> retrieveQuestionDetail(String role, String questionId,
      String writerId) {
    AdminRoleUtils.checkRole(role);
    return authServiceClient.retrieveQuestionDetailByAdmin(role,questionId);
  }
}
