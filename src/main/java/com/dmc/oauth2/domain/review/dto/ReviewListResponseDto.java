package com.dmc.oauth2.domain.review.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class ReviewListResponseDto {
    private Long reviewNum;
    private Long news_id;
    private Long user_id;
    private String reviewComment;
    private String reviewLike;



    @QueryProjection
    public ReviewListResponseDto(Long reviewNum, Long news_id, Long user_id,  String reviewComment, String reviewLike){
        this.reviewNum = reviewNum;
        this.news_id = news_id;
        this.user_id = user_id;
        this.reviewComment = reviewComment;
        this.reviewLike = reviewLike;
    }

}


