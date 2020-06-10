package com.dmc.oauth2.domain.event;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter	@Setter
@Table(name = "event")
@ApiModel(description = "편의점 이벤트 상품 정보를 위한 도메인 객체")
public class Event {
	
	@Id	@GeneratedValue
	@Column(name = "event_id")
    @ApiModelProperty(notes = "이벤트 번호입니다.")
    private Long eventNum;
    

	@ApiModelProperty(notes = "상품명을 입력해 주세요.")
    private String name;


    private int price;
    @ApiModelProperty(notes = "상품 이벤트 구분을 입력해 주세요.")
    private String evt;

    @ApiModelProperty(notes = "상품 카테고리를 입력해 주세요.")
    private String product1;
    private String store;
    private String product2;
    private String img;
    private Date registerDate;
    private Date expireDate;

}