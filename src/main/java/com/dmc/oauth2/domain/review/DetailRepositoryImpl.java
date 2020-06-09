package com.dmc.oauth2.domain.review;


import com.dmc.oauth2.domain.review.dto.QReviewListResponseDto;
import com.dmc.oauth2.domain.review.dto.ReviewListResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static com.dmc.oauth2.domain.review.QReview.review;
import static com.dmc.oauth2.domain.news.QNews.news;
import static com.dmc.oauth2.domain.user.QUser.user;


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
                        news.newsNum,
                        user.id,
                        review.reviewComment,
                        review.reviewLike
                ))
                .from(review)
                .fetch();
    }


}
