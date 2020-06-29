package com.dmc.oauth2.domain.etfFunds;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "etf_funds")
@ApiModel(description = "ETF 정보를 위한 도메인 객체")
public class EtfFunds {

    @Id
    @Column(name = "etf_num")
    private Long etf_num;

    @ApiModelProperty(notes = "ETF 이름을 입력해 주세요.")
    private String etf_name;

    @ApiModelProperty(notes = "ETF 기초자산을 입력해 주세요.")
    private String etf_basic_index;
    private Long etf_close;
    private Long etf_assets;
    private Float etf_1dY;
    private Float etf_1wY;
    private Float etf_1mY;
    private Float etf_3mY;
    private Long etf_1d_volume;

}
