package com.liberty52.admin.service.applicationservice;

import com.liberty52.admin.global.adapter.feign.dto.NoticeDetailRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.NoticeRetrieveResponse;
import org.springframework.data.domain.Pageable;

public interface NoticeRetrieveService {

    NoticeRetrieveResponse retrieveNotices(String role, Pageable pageable);

    NoticeDetailRetrieveResponse retrieveNoticeDetail(String role, String noticeId);

}
