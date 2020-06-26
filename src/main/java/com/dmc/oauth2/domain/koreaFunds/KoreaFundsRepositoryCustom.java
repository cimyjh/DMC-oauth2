package com.dmc.oauth2.domain.koreaFunds;

import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsListResponseDto;
import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsNameDto;
import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsTypeDto;

import java.util.List;

public interface KoreaFundsRepositoryCustom {
    List<KoreaFundsListResponseDto> findAllDto();

    List<KoreaFundsListResponseDto> QfindTop10ByFund_3y();

    List<KoreaFundsListResponseDto> QfindTop10ByFund_assets();

    List<KoreaFundsListResponseDto> QfindSearchName(KoreaFundsNameDto condition);

    List<KoreaFundsListResponseDto> QfindSearchType(KoreaFundsTypeDto condition);
}
