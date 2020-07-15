package com.dmc.oauth2.service;

import com.dmc.oauth2.domain.user.User;
import com.dmc.oauth2.domain.news.News;
import com.dmc.oauth2.domain.review.Review;
import com.dmc.oauth2.domain.review.DetailRepository;
import com.dmc.oauth2.domain.user.UserRepository;
import com.dmc.oauth2.domain.news.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class DetailService {

	@Autowired
	private DetailRepository detailRepository;

	@Autowired
	private NewsRepository newsRepository;

	@Autowired
	private UserRepository userRepository;


	public List<Review> findReviewByNews(Long newsNum) {
		return detailRepository.findReviewByNews(newsNum);
	}


	@Transactional
	public Review insertReview(long newsNum, String name, String reviewComment, String reviewLike) {
		News news = newsRepository.findByNewsNum(newsNum);
		User user = userRepository.findByName(name);

		Review review = Review.createReview(user, news, reviewComment, reviewLike);

		return detailRepository.save(review);

		//return review.getReviewNum();
	}
}
