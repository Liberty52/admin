package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminQuestionRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.QuestionDetailResponseDto;
import com.liberty52.admin.global.utils.AdminRoleUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class QuestionRetrieveServiceImpl implements QuestionRetrieveService{

  private final AuthServiceClient authServiceClient;
  @Override
  public ResponseEntity<AdminQuestionRetrieveResponse> retrieveAllQuestions(String role,
      int pageNumber, int size) {
    AdminRoleUtils.checkRole(role);
    return authServiceClient.retrieveAllQuestions(role,pageNumber,size);
  }

  @Override
  public ResponseEntity<QuestionDetailResponseDto> retrieveQuestionDetail(String role, String questionId,
      String writerId) {
    AdminRoleUtils.checkRole(role);
    return authServiceClient.retrieveQuestionDetail(role,questionId);
  }
}
