package com.liberty52.admin.global.adapter.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "product", primary = false)
public interface ProductServiceClient {

}
