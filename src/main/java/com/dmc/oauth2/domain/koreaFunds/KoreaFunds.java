package com.dmc.oauth2.domain.koreaFunds;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "koreaFunds")
public class KoreaFunds {

    @Id
    @Column(name = "fund_num")
    private Long fund_num;

    private String fund_name;
    private String fund_type;
    private String fund_startDate;
    private Float fund_3y;
    private Long fund_assets;
    private Long fund_scaleOperation;

}
