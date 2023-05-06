package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.dto.AdminQuestionRetrieveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class QuestionRetrieveServiceImpl implements QuestionRetrieveService{

  @Override
  public ResponseEntity<AdminQuestionRetrieveResponse> retrieveAllQuestions(String role,
      int pageNumber, int size) {
    return null;
  }
}
