package com.liberty52.admin.global.adapter.feign.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestionDetailResponseDto {

  private String id;
  private String title;
  private String content;
  private String status;
  private String writerId;
  private LocalDate createdAt;
  private QuestionReplyResponse questionReplyResponse;

  @Data
  @AllArgsConstructor
  public class QuestionReplyResponse {

    private String replyId;
    private String replyContent;
    private String replyWriterId;
    private LocalDate replyCreatedAt;
  }

}
