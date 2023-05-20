package com.liberty52.admin.global.adapter.feign.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private String authorId;
    private String authorName;
    private Integer rating;
    private String content;
    private List<String> imageUrls;
  }
}