package com.liberty52.admin.global.adapter.feign.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminQuestionRetrieveResponse {
  private List<QuestionContent> contents;
  private long currentPage;
  private long startPage;
  private long lastPage;
  private long totalPage;

  @Data
  public class QuestionContent{
    private String id;
    private String status;
    private String title;
    private String content;
    private String writerId;
    private LocalDate createdAt;
    private String email;
  }
}
