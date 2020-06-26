package com.dmc.oauth2.api;

import com.dmc.oauth2.domain.etfFunds.EtfFundsRepository;
import com.dmc.oauth2.domain.koreaFunds.KoreaFundsRepository;
import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class KoreaFundApiController {
    private final KoreaFundsRepository koreaFundsRepository;
    private final EtfFundsRepository etfFundsRepository;


    @GetMapping("/v1/fund/koreafunds")
    public List<KoreaFundsListResponseDto> KoreaFundsFindAll(){
        return koreaFundsRepository.findAllDto();
    }


    @GetMapping("/v1/fund/koreafunds/top10")
    public List<KoreaFundsListResponseDto> KoreadFundsTop10(){
        return koreaFundsRepository.QfindTop10ByFund_3y();
    }



}
