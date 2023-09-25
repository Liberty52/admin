package com.liberty52.admin.service.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ProductInfoRetrieveResponseDto {

    String id;
    String pictureUrl;
    String name;
    long price;
    float meanRating;
    int ratingCount;
    String state;
    String introductionImageUrl;
}
