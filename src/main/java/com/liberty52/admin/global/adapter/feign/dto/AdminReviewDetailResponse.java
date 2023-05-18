package com.liberty52.admin.global.adapter.feign.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminReviewDetailResponse {

  private AdminReviewContent content;

  @Data
  @AllArgsConstructor
  public static class AdminReviewContent {
    private Integer rating;
    private String content;
    private List<String> imageUrls;
    private String authorId;
    private LocalDate reviewCreatedAt;
    private List<ReplyContent> replies;
  }

  @Data
  public static class ReplyContent{
    private String authorId;
    private String content;
    private String replyId;
    private LocalDate replyCreatedAt;
  }
}