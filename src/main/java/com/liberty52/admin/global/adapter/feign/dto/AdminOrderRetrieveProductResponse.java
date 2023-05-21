package com.liberty52.admin.global.adapter.feign.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
public class AdminOrderRetrieveProductResponse {

    private String customProductId;
    private String name;
    private int quantity;
    private Long price;

    private String productUrl;

    private List<String> options;

}
