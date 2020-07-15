package com.dmc.oauth2.api;

import com.dmc.oauth2.apiException.NotFoundException;
import com.dmc.oauth2.domain.etfFunds.EtfFundsRepository;
import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsListResponseDto;
import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsNameDto;
import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsbasicIndexDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ETFApiController {
    private final EtfFundsRepository etfFundsRepository;

    @ApiOperation(value = "ETF 전체조회", notes = "모든 ETF를 조회한다.")
    @GetMapping("/v1/fund/etffunds")
    public List<EtfFundsListResponseDto> EtfFundsFindAll(){
        return etfFundsRepository.findAllDto();
    }


    @ApiOperation(value = "ETF 1주일 수익률 상위 10개 조회", notes = "ETF 1주일일 수익 상위 10개 조회한다.")
    @GetMapping("/v1/fund/etffunds/1wytop10")
    public List<EtfFundsListResponseDto> QfindTop10ByEtf_1wY(){
        return etfFundsRepository.QfindTop10ByEtf_1wY();
    }


    @ApiOperation(value = "ETF 1개월 수익률 상위 10개 조회", notes = "ETF 1개월 수익률 상위 10개 조회한다.")
    @GetMapping("/v1/fund/etffunds/1mytop10")
    public List<EtfFundsListResponseDto> QfindTop10ByEtf_1mY(){
        return etfFundsRepository.QfindTop10ByEtf_1mY();
    }


    @ApiOperation(value = "ETF 3개월 수익률 상위 10개 조회", notes = "ETF 3개월 수익률 상위 10개 조회한다.")
    @GetMapping("/v1/fund/etffunds/3mytop10")
    public List<EtfFundsListResponseDto> QfindTop10ByEtf_3mY(){
        return etfFundsRepository.QfindTop10ByEtf_3mY();
    }


    @ApiOperation(value = "ETF 1일 수익률 상위 10개 조회", notes = "ETF 1일 수익률 상위 10개 조회한다.")
    @GetMapping("/v1/fund/etffunds/1dvtop10")
    public List<EtfFundsListResponseDto> QfindTop10ByEtf_1dV(){
        return etfFundsRepository.QfindTop10ByEtf_1dV();
    }


    @ApiOperation(value = "ETF 자산규모 상위 10개 조회", notes = "ETF 자산규모 상위 10개 조회한다.")
    @GetMapping("/v1/fund/etffunds/asset_top10")
    public List<EtfFundsListResponseDto> QfindTop10ByEtf_assets(){
        return etfFundsRepository.QfindTop10ByEtf_assets();
    }

    @ApiOperation(value = "ETF 이름조회", notes = "ETF를 이름으로 조회한다.")
    @GetMapping("/v1/fund/etffunds/findSearchName")
    public List<EtfFundsListResponseDto> QfindSearchName(EtfFundsNameDto condition){
        List<EtfFundsListResponseDto> etfList = etfFundsRepository.QfindSearchName(condition);

        if(etfList.isEmpty()){
            throw new NotFoundException(String.format("name[%s] not found",condition));
        }

        return etfList;
    }

    @ApiOperation(value = "ETF 기초자산 조회", notes = "ETF를 기초자산으로 조회한다.")
    @GetMapping("/v1/fund/etffunds/findSearchBasic_Index")
    public List<EtfFundsListResponseDto> QfindSearchBasic_Index(EtfFundsbasicIndexDto condition){
        List<EtfFundsListResponseDto> etfList = etfFundsRepository.QfindSearchBasic_Index(condition);

        if(etfList.isEmpty()){
            throw new NotFoundException(String.format("basic_index [%s] not found",condition));
        }

        return etfList;
    }




}
