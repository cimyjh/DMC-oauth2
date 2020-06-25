package com.dmc.oauth2.domain.koreaFunds.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class KoreaFundsListResponseDto {
    private Long fund_num;
    private String fund_name;
    private String fund_type;
    private String fund_startDate;
    private Float fund_3y;
    private Long fund_assets;
    private Long fund_scaleOperation;

    @QueryProjection
    public KoreaFundsListResponseDto(Long fund_num, String fund_name, String fund_type,
                                     String fund_startDate, Float fund_3y, Long fund_assets,
                                     Long fund_scaleOperation){
        this.fund_num = fund_num;
        this.fund_name = fund_name;
        this.fund_type = fund_type;
        this.fund_startDate = fund_startDate;
        this.fund_3y = fund_3y;
        this.fund_assets = fund_assets;
        this.fund_scaleOperation = fund_scaleOperation;
    }
}
