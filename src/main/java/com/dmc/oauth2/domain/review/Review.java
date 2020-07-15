package com.dmc.oauth2.domain.review;

import com.dmc.oauth2.domain.news.News;
import com.dmc.oauth2.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Review {
	
	@Id @GeneratedValue
	@Column(name = "review_id")
	private Long reviewNum;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="news_id")
	private News news;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="user_id")
	private User user;
	
	private String reviewComment;
	private String reviewLike;


	//연관관계 편의 메소드
	public void setUser(User user){
		this.user = user;
		user.getReviews().add(this);
	}

	public void setNews(News news){
		this.news = news;
		news.getReviews().add(this);
	}


	public static Review createReview(User user, News news, String reviewComment, String reviewLike){
		Review review = new Review();
		review.setUser(user);
		review.setNews(news);
		review.setReviewComment(reviewComment);
		review.setReviewLike(reviewLike);
		//review.setReviewDate(LocalDateTime.now());
		return review;

	}
}
