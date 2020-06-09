package com.dmc.oauth2.domain.review;


import com.dmc.oauth2.domain.review.dto.QReviewListResponseDto;
import com.dmc.oauth2.domain.review.dto.ReviewListResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static com.dmc.oauth2.domain.review.QReview.review;


public class DetailRepositoryImpl implements DetailRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    public DetailRepositoryImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ReviewListResponseDto> findAllDto() {
        return queryFactory
                .select(new QReviewListResponseDto(
                        review.reviewNum,
                        review.reviewComment,
                        review.reviewLike
                ))
                .from(review)
                .fetch();
    }


}
