package com.dmc.oauth2.domain.koreaFunds.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class KoreaFundsListResponseDto {
    private Long fund_num;
    private String fund_name;
    private String fund_type;
    private String fund_start_date;
    private Float fund3y;
    private Long fund_assets;
    private Long fund_scale_operation;

    @QueryProjection
    public KoreaFundsListResponseDto(Long fund_num, String fund_name, String fund_type,
                                     String fund_start_date, Float fund3y, Long fund_assets,
                                     Long fund_scale_operation){
        this.fund_num = fund_num;
        this.fund_name = fund_name;
        this.fund_type = fund_type;
        this.fund_start_date = fund_start_date;
        this.fund3y = fund3y;
        this.fund_assets = fund_assets;
        this.fund_scale_operation = fund_scale_operation;
    }
}
