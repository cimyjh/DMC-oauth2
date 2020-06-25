package com.dmc.oauth2.domain.etfFunds.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class EtfFundsListResponseDto {
    private Long etf_num;
    private String etf_name;
    private String etf_basicIndex;
    private Long etf_close;
    private Long etf_assets;
    private Float etf_1dY;
    private Float etf_1wY;
    private Float etf_1mY;
    private Float etf_3mY;
    private Long etf_1dVolume;


    @QueryProjection
    public EtfFundsListResponseDto(Long etf_num, String etf_name, String etf_basicIndex,
                                   Long etf_close, Long etf_assets, Float etf_1dY,Float etf_1wY,
                                   Float etf_1mY, Float etf_3mY, Long etf_1dVolume){
        this.etf_num = etf_num;
        this.etf_name = etf_name;
        this.etf_basicIndex = etf_basicIndex;
        this.etf_close = etf_close;
        this.etf_assets = etf_assets;
        this.etf_1dY = etf_1dY;
        this.etf_1wY = etf_1wY;
        this.etf_1mY = etf_1mY;
        this.etf_3mY = etf_3mY;
        this.etf_1dVolume = etf_1dVolume;
    }
}
