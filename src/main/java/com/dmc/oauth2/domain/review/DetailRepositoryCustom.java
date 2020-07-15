package com.dmc.oauth2.domain.review;


import com.dmc.oauth2.domain.review.dto.ReviewListResponseDto;

import java.util.List;

public interface DetailRepositoryCustom {

    List<ReviewListResponseDto> findAllDto();
}
