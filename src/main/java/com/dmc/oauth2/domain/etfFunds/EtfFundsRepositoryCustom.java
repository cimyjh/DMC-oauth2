package com.dmc.oauth2.domain.etfFunds;

import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsListResponseDto;

import java.util.List;

public interface EtfFundsRepositoryCustom {
    List<EtfFundsListResponseDto> findAllDto();

    List<EtfFundsListResponseDto> QfindTop10ByEtf_1wY();

    List<EtfFundsListResponseDto> QfindTop10ByEtf_1mY();

    List<EtfFundsListResponseDto> QfindTop10ByEtf_3mY();

    List<EtfFundsListResponseDto> QfindTop10ByEtf_1dV();
}
