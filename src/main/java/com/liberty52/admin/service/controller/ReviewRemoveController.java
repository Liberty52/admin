package com.liberty52.admin.service.controller;

import com.liberty52.admin.service.applicationservice.ReviewRemoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewRemoveController {
    private final ReviewRemoveService reviewItemRemoveService;

    @DeleteMapping("/customerReviews/{reviewId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeCustomerReview(@RequestHeader(HttpHeaders.AUTHORIZATION) String adminId, @RequestHeader("LB-Role") String role, @PathVariable String reviewId) {

        reviewItemRemoveService.removeCustomerReview(adminId, role, reviewId);
    }
}
