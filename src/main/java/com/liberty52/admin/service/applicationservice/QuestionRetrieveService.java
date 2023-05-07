package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.dto.AdminQuestionRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.QuestionDetailResponseDto;
import org.springframework.http.ResponseEntity;

public interface QuestionRetrieveService {
  ResponseEntity<AdminQuestionRetrieveResponse> retrieveAllQuestions(String role,int pageNumber,int size);

  ResponseEntity<QuestionDetailResponseDto> retrieveQuestionDetail(String role, String questionId, String writerId);
}
