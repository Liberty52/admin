package com.liberty52.admin.global.adapter.feign;

import com.liberty52.admin.global.adapter.feign.dto.AdminLoginRequestDto;
import com.liberty52.admin.global.adapter.feign.dto.AdminLoginResponseDto;
import com.liberty52.admin.global.adapter.feign.dto.AdminQuestionRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.AuthClientDataResponse;
import com.liberty52.admin.global.adapter.feign.dto.AuthProfileDto;
import com.liberty52.admin.global.adapter.feign.dto.NoticeDetailRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.NoticeRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.QuestionDetailResponseDto;
import com.liberty52.admin.service.controller.dto.CustomerInfoListResponseDto;
import com.liberty52.admin.service.controller.dto.NoticeCreateRequestDto;
import com.liberty52.admin.service.controller.dto.NoticeModifyRequestDto;
import com.liberty52.admin.service.controller.dto.QuestionReplyCreateRequestDto;
import com.liberty52.admin.service.controller.dto.QuestionReplyModifyRequestDto;
import java.util.Map;
import java.util.Set;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(value = "auth", primary = false)
public interface AuthServiceClient {

  @PostMapping(value = "/login")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<AdminLoginResponseDto> login(AdminLoginRequestDto dto);

  @GetMapping(value = "/my")
  AuthProfileDto getAuthProfile(@RequestHeader(HttpHeaders.AUTHORIZATION) String authId);

  @PostMapping("/info")
  Map<String, AuthClientDataResponse> retrieveAuthData(@RequestBody Set<String> ids);

  @PutMapping("/admin/questionReplies/{questionReplyId}")
  void modifyQuestionReplyByAdmin(
      @RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
      @RequestHeader("LB-Role") String role,
      @Validated @RequestBody QuestionReplyModifyRequestDto dto,
      @PathVariable String questionReplyId);

  @DeleteMapping("/admin/questionReplies/{questionReplyId}")
  @ResponseStatus(HttpStatus.OK)
  void deleteQuestionReplyByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
      @RequestHeader("LB-Role") String role, @PathVariable String questionReplyId);

  @PostMapping("/admin/questionReplies")
  @ResponseStatus(HttpStatus.CREATED)
  void createQuestionReplyByAdmin(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
      @RequestHeader("LB-Role") String role,
      @Validated @RequestBody QuestionReplyCreateRequestDto dto);

  @GetMapping("/admin/questions")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<AdminQuestionRetrieveResponse> retrieveQuestionByAdmin(
      @RequestHeader("LB-Role") String role,
      @RequestParam(value = "page", defaultValue = "0") int pageNumber,
      @RequestParam(value = "size", defaultValue = "10") int size);

  @GetMapping("/admin/questions/{questionId}")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<QuestionDetailResponseDto> retrieveQuestionDetailByAdmin(
      @RequestHeader("LB-Role") String role, @PathVariable("questionId") String questionId);

  @PutMapping("/admin/notices/{noticeId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void modifyNoticeByAdmin(@RequestHeader("LB-Role") String role,
      @PathVariable String noticeId,
      @Validated @RequestBody NoticeModifyRequestDto dto);

  @GetMapping("/admin/customer-info")
  @ResponseStatus(HttpStatus.OK)
  CustomerInfoListResponseDto retrieveCustomerInfoByAdmin(@RequestHeader("LB-Role") String role,
      Pageable pageable);

  @PostMapping("/admin/notices")
  @ResponseStatus(HttpStatus.CREATED)
  void createNoticeByAdmin(@RequestHeader("LB-Role") String role,
      @Validated @RequestBody NoticeCreateRequestDto dto);

  @GetMapping("/admin/notices")
  @ResponseStatus(HttpStatus.OK)
  NoticeRetrieveResponse retrieveNoticesByAdmin(@RequestHeader("LB-Role") String role,
      Pageable pageable);

  @GetMapping("/admin/notices/{noticeId}")
  @ResponseStatus(HttpStatus.OK)
  NoticeDetailRetrieveResponse retrieveNoticeDetailByAdmin(@RequestHeader("LB-Role") String role,
      @PathVariable String noticeId);

  @DeleteMapping("/admin/notices/{noticeId}")
  void deleteNoticeByAdmin(@RequestHeader("LB-Role") String role, @PathVariable String noticeId);
}
