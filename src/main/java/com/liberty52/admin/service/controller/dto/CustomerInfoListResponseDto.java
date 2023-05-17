package com.liberty52.admin.service.controller.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerInfoListResponseDto {
    private List<UserInfoResponseDto> infoList;
    private long totalCount;
    private int numberOfElements;
    private int pageNumber;
    private boolean hasPrev;
    private boolean hasNext;
    private boolean first;
    private boolean last;
}
