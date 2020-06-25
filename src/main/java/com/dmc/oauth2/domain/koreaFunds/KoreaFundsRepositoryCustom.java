package com.dmc.oauth2.domain.koreaFunds;

import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsListResponseDto;

import java.util.List;

public interface KoreaFundsRepositoryCustom {
    List<KoreaFundsListResponseDto> findAllDto();

    List<KoreaFundsListResponseDto> findTop10ByFund_3y();
}
