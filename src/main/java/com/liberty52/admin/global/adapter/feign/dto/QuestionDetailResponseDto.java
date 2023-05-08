package com.liberty52.admin.global.adapter.feign.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
  @NoArgsConstructor
  public static class QuestionReplyResponse {
    private String replyId;
    private String replyContent;
    private String replyWriterId;
    private LocalDate replyCreatedAt;
  }
}
