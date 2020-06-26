package com.dmc.oauth2.api;

import com.dmc.oauth2.apiException.NotFoundException;
import com.dmc.oauth2.domain.etfFunds.EtfFundsRepository;
import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsListResponseDto;
import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsNameDto;
import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsbasicIndexDto;
import com.dmc.oauth2.domain.koreaFunds.KoreaFundsRepository;
import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsListResponseDto;
import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsNameDto;
import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsTypeDto;
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


    @GetMapping("/v1/fund/koreafunds/asset_top10")
    public List<KoreaFundsListResponseDto> findTop10ByFund_assets(){
        return koreaFundsRepository.QfindTop10ByFund_assets();
    }

    @GetMapping("/v1/fund/koreafunds/findSearchName")
    public List<KoreaFundsListResponseDto> QfindSearchName(KoreaFundsNameDto condition){
        List<KoreaFundsListResponseDto> koreaFundsList = koreaFundsRepository.QfindSearchName(condition);

        if(koreaFundsList.isEmpty()){
            throw new NotFoundException(String.format("name[%s] not found",condition));
        }

        return koreaFundsList;
    }

    @GetMapping("/v1/fund/koreafunds/findSearchType")
    public List<KoreaFundsListResponseDto> QfindSearchType(KoreaFundsTypeDto condition){
        List<KoreaFundsListResponseDto> koreaFundsList = koreaFundsRepository.QfindSearchType(condition);

        if(koreaFundsList.isEmpty()){
            throw new NotFoundException(String.format("Type [%s] not found",condition));
        }

        return koreaFundsList;
    }



}
