package com.dmc.oauth2.domain.news;

import com.dmc.oauth2.domain.review.Review;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "news")
public class News {
	
	@Id @GeneratedValue
	@Column(name = "news_id")
	private Long newsNum;
	
	private String name;
	private int price;
	private String product1;
	private String product2;
	private String thumbnail;
	private String img;
	private String store;
	private String detail;
	private Date registerDate;
	
	
	@OneToMany(mappedBy = "news")
	private List<Review> reviews = new ArrayList<>();


	public void addReview(Review review){
		reviews.add(review);
		review.setNews(this);
	}



	
}
