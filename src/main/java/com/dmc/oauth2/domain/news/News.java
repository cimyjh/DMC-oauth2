package com.dmc.oauth2.domain.news;

import com.dmc.oauth2.domain.review.Review;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "편의점 신상품 상품 정보를 위한 도메인 객체")
public class News {
	
	@Id @GeneratedValue
	@Column(name = "news_id")
	private Long newsNum;

	@ApiModelProperty(notes = "상품명을 입력해 주세요.")
	private String name;
	private int price;

	@ApiModelProperty(notes = "상품 카테고리를 입력해 주세요.")
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
