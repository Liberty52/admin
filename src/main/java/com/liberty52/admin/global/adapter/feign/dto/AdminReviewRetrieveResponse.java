package com.liberty52.admin.global.adapter.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AdminReviewRetrieveResponse {

  private List<AdminReviewContent> contents;
  private long currentPage;
  private long startPage;
  private long lastPage;
  private long totalLastPage;

  @Data
  @AllArgsConstructor
  public static class AdminReviewContent {
    private String reviewId;
    private Integer rating;
    private String content;
    private List<String> imageUrls;
    private int nOfReply;
    private String authorId;
    private String authorName;
    private String authorProfileUrl;
    private List<ReplyContent> replies;
  }

  @Data
  @AllArgsConstructor
  public static class ReplyContent {
    private String authorId;
    private String authorName;
    private String authorProfileUrl;
    private String content;
    private String replyId;
  }
}