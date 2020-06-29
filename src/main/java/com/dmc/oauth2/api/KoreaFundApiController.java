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
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class KoreaFundApiController {
    private final KoreaFundsRepository koreaFundsRepository;
    private final EtfFundsRepository etfFundsRepository;


    @ApiOperation(value = "펀드 전체조회", notes = "모든 펀드를 조회한다.")
    @GetMapping("/v1/fund/koreafunds")
    public List<KoreaFundsListResponseDto> KoreaFundsFindAll(){
        return koreaFundsRepository.findAllDto();
    }


    @ApiOperation(value = "펀드 3개월 수익률 상위 10개 조회", notes = "펀드 3개월 수익률 상위 10개 조회한다.")
    @GetMapping("/v1/fund/koreafunds/top10")
    public List<KoreaFundsListResponseDto> KoreadFundsTop10(){
        return koreaFundsRepository.QfindTop10ByFund_3y();
    }


    @ApiOperation(value = "펀드 자산규모 상위 10개 조회", notes = "펀드 자산규모 상위 10개 조회한다.")
    @GetMapping("/v1/fund/koreafunds/asset_top10")
    public List<KoreaFundsListResponseDto> findTop10ByFund_assets(){
        return koreaFundsRepository.QfindTop10ByFund_assets();
    }

    @ApiOperation(value = "펀드 이름 조회", notes = "펀드 이름으로 조회한다.")
    @GetMapping("/v1/fund/koreafunds/findSearchName")
    public List<KoreaFundsListResponseDto> QfindSearchName(KoreaFundsNameDto condition){
        List<KoreaFundsListResponseDto> koreaFundsList = koreaFundsRepository.QfindSearchName(condition);

        if(koreaFundsList.isEmpty()){
            throw new NotFoundException(String.format("name[%s] not found",condition));
        }

        return koreaFundsList;
    }

    @ApiOperation(value = "펀드 타입 조회", notes = "펀드 타입으로 조회한다.")
    @GetMapping("/v1/fund/koreafunds/findSearchType")
    public List<KoreaFundsListResponseDto> QfindSearchType(KoreaFundsTypeDto condition){
        List<KoreaFundsListResponseDto> koreaFundsList = koreaFundsRepository.QfindSearchType(condition);

        if(koreaFundsList.isEmpty()){
            throw new NotFoundException(String.format("Type [%s] not found",condition));
        }

        return koreaFundsList;
    }



}
