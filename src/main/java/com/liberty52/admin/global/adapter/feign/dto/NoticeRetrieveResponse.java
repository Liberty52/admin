package com.liberty52.admin.global.adapter.feign.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class NoticeRetrieveResponse {

    private List<NoticeContent> contents;
    private long startPage;
    private long currentPage;
    private long lastPage;
    private long totalPage;
    private long totalCount;

    @Getter
    public static class NoticeContent {
        private String noticeId;
        private String title;
        private String createdAt;
    }
}
