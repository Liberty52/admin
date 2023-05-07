package com.liberty52.admin.global.adapter.feign;

import com.liberty52.admin.global.adapter.feign.dto.AdminQuestionRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.AuthClientDataResponse;
import com.liberty52.admin.global.adapter.feign.dto.AuthProfileDto;
import com.liberty52.admin.service.controller.dto.QuestionReplyCreateRequestDto;
import com.liberty52.admin.global.adapter.feign.dto.QuestionDetailResponseDto;
import com.liberty52.admin.service.controller.dto.QuestionReplyModifyRequestDto;
import java.util.Map;
import java.util.Set;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "auth", primary = false)
public interface AuthServiceClient {

    @GetMapping(value = "/my")
    AuthProfileDto getAuthProfile(@RequestHeader(HttpHeaders.AUTHORIZATION) String authId);

    @PostMapping("/info")
    Map<String, AuthClientDataResponse> retrieveAuthData(@RequestBody Set<String> ids);

    @PutMapping("/questionReplies/{questionReplyId}")
    void questionReplyModify(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
            @RequestHeader("LB-Role") String role,
            @Validated @RequestBody QuestionReplyModifyRequestDto dto, @PathVariable String questionReplyId) ;

    @DeleteMapping("/questionReplies/{questionReplyId}")
    @ResponseStatus(HttpStatus.OK)
    void deleteQuestionReply(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId, @RequestHeader("LB-Role") String role, @PathVariable String questionReplyId);
    
    @PostMapping("/questionReplies")
    @ResponseStatus(HttpStatus.CREATED)
    void createQuestionReply(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId, @RequestHeader("LB-Role") String role, @Validated @RequestBody QuestionReplyCreateRequestDto dto);

    @GetMapping("/all-questions")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<AdminQuestionRetrieveResponse> retrieveAllQuestions(@RequestHeader("LB-Role") String role,
        @RequestParam(value = "page", defaultValue = "0") int pageNumber,
        @RequestParam(value = "size", defaultValue = "10") int size);

    @GetMapping("/all-questions/{questionId}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<QuestionDetailResponseDto> retrieveQuestionDetail(@RequestHeader("LB-Role") String role, @PathVariable("questionId") String questionId);

}
