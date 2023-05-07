package com.liberty52.admin.service.applicationservice;

import static com.liberty52.admin.global.constants.RoleConstants.ADMIN;

import com.liberty52.admin.global.adapter.feign.AuthServiceClient;
import com.liberty52.admin.global.adapter.feign.dto.AdminQuestionRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.QuestionDetailResponseDto;
import com.liberty52.admin.global.exception.external.forbidden.InvalidRoleException;
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
    if(!ADMIN.equals(role)){
      throw new InvalidRoleException(role);
    }
    return authServiceClient.retrieveAllQuestions(role,pageNumber,size);
  }

  @Override
  public ResponseEntity<QuestionDetailResponseDto> retrieveQuestionDetail(String role, String questionId,
      String writerId) {
    if(!ADMIN.equals(role)){
      throw new InvalidRoleException(role);
    }
    return authServiceClient.retrieveQuestionDetail(questionId,writerId);
  }
}
