package com.liberty52.admin.global.adapter.feign;

import com.liberty52.admin.global.adapter.feign.dto.AdminQuestionRetrieveResponse;
import com.liberty52.admin.global.adapter.feign.dto.AuthClientDataResponse;
import com.liberty52.admin.global.adapter.feign.dto.AuthProfileDto;
import com.liberty52.admin.global.adapter.feign.dto.QuestionDetailResponseDto;
import com.liberty52.admin.service.controller.dto.QuestionReplyModifyRequestDto;
import java.util.Map;
import java.util.Set;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

    @GetMapping(value = "/my")
    AuthProfileDto getAuthProfile(@RequestHeader(HttpHeaders.AUTHORIZATION) String authId);

    @PostMapping("/info")
    Map<String, AuthClientDataResponse> retrieveAuthData(@RequestBody Set<String> ids);

    @PutMapping("/questionReplies/{questionReplyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void questionReplyModify(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String adminId,
            @RequestHeader("LB-Role") String role,
            @Validated @RequestBody QuestionReplyModifyRequestDto dto, @PathVariable String questionReplyId) ;

    @DeleteMapping("/customerReviews/{reviewId}")
    @ResponseStatus(HttpStatus.OK)
    void removeCustomerReview(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId, @RequestHeader("LB-Role") String role, @PathVariable String reviewId);
            @Validated @RequestBody QuestionReplyModifyRequestDto dto, @PathVariable String questionReplyId);

    @GetMapping("/all-questions")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<AdminQuestionRetrieveResponse> retrieveAllQuestions(@RequestHeader("LB-Role") String role,
        @RequestParam(value = "page", defaultValue = "0") int pageNumber,
        @RequestParam(value = "size", defaultValue = "10") int size);

    @GetMapping("/questions/{questionId}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<QuestionDetailResponseDto> retrieveQuestionDetail(@PathVariable("questionId") String questionId,
        @RequestHeader(HttpHeaders.AUTHORIZATION) String writerId);
}
