package com.dmc.oauth2.domain.etfFunds;

import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsListResponseDto;

import java.util.List;

public interface EtfFundsRepositoryCustom {
    List<EtfFundsListResponseDto> findAllDto();
}
