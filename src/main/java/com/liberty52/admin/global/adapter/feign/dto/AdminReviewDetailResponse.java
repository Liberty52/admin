package com.liberty52.admin.global.adapter.feign.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminReviewDetailResponse {

  private AdminReviewContent content;

  @Data
  public static class AdminReviewContent {
    private Integer rating;
    private String content;
    private List<String> imageUrls;
    private String authorId;
    private String authorName;
    private LocalDate reviewCreatedAt;
    private List<ReplyContent> replies;
  }

  @Data
  public static class ReplyContent{
    private String authorId;
    private String authorName;
    private String content;
    private String replyId;
    private LocalDate replyCreatedAt;
  }
}