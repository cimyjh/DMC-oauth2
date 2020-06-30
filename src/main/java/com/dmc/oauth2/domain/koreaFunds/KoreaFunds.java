package com.dmc.oauth2.domain.koreaFunds;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "korea_funds")
@ApiModel(description = "펀드 정보를 위한 도메인 객체")
public class KoreaFunds {

    @Id
    @Column(name = "fund_num")
    private Long fund_num;

    @ApiModelProperty(notes = "펀드 이름을 입력해 주세요.")
    private String fund_name;

    @ApiModelProperty(notes = "펀드 타입을 입력해 주세요.")
    private String fund_type;
    private String fund_start_date;

    @Column(name = "fund_3y")
    private Float fund_3y;

    private Long fund_assets;
    private Long fund_scale_operation;


}
