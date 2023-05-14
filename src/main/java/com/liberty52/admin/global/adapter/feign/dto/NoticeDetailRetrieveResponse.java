package com.liberty52.admin.global.adapter.feign.dto;

import lombok.Getter;

@Getter
public class NoticeDetailRetrieveResponse {

    private String noticeId;
    private String title;
    private String content;
    private String createdAt;
    private boolean commentable;

}
