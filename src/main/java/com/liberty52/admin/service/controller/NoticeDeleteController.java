package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.NoticeDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class NoticeDeleteController {

  private final NoticeDeleteService noticeDeleteService;

  @DeleteMapping("/notices/{noticeId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteNotice(@RequestHeader("LB-Role") String role, @PathVariable String noticeId) {
    noticeDeleteService.deleteNotice(role, noticeId);
  }
}
