package com.liberty52.admin.service.controller;

import com.liberty52.admin.global.adapter.feign.dto.AdminQuestionRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.QuestionDetailResponseDto;
import com.liberty52.admin.service.applicationservice.QuestionRetrieveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class QuestionRetrieveController {

  private final QuestionRetrieveService questionRetrieveService;

  @GetMapping("/questions")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<AdminQuestionRetrieveResponse> retrieveAllQuestions(
      @RequestHeader("LB-Role") String role,
      @RequestParam(value = "page", defaultValue = "0") int pageNumber,
      @RequestParam(value = "size", defaultValue = "10") int size) {
    return questionRetrieveService.retrieveAllQuestions(role, pageNumber, size);
  }

  @GetMapping("/questions/{questionId}")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<QuestionDetailResponseDto> retrieveQuestionDetail(@RequestHeader("LB-Role") String role,
      @PathVariable("questionId") String questionId,
      @RequestHeader(HttpHeaders.AUTHORIZATION) String writerId){
    return questionRetrieveService.retrieveQuestionDetail(role,questionId,writerId);
  }
}
