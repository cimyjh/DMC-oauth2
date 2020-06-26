package com.dmc.oauth2.api;

import com.dmc.oauth2.apiException.NotFoundException;
import com.dmc.oauth2.domain.etfFunds.EtfFundsRepository;
import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsListResponseDto;
import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsNameDto;
import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsbasicIndexDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ETFApiController {
    private final EtfFundsRepository etfFundsRepository;


    @GetMapping("/v1/fund/etffunds")
    public List<EtfFundsListResponseDto> EtfFundsFindAll(){
        return etfFundsRepository.findAllDto();
    }

    @GetMapping("/v1/fund/etffunds/1wytop10")
    public List<EtfFundsListResponseDto> QfindTop10ByEtf_1wY(){
        return etfFundsRepository.QfindTop10ByEtf_1wY();
    }

    @GetMapping("/v1/fund/etffunds/1mytop10")
    public List<EtfFundsListResponseDto> QfindTop10ByEtf_1mY(){
        return etfFundsRepository.QfindTop10ByEtf_1mY();
    }

    @GetMapping("/v1/fund/etffunds/3mytop10")
    public List<EtfFundsListResponseDto> QfindTop10ByEtf_3mY(){
        return etfFundsRepository.QfindTop10ByEtf_3mY();
    }

    @GetMapping("/v1/fund/etffunds/1dvtop10")
    public List<EtfFundsListResponseDto> QfindTop10ByEtf_1dV(){
        return etfFundsRepository.QfindTop10ByEtf_1dV();
    }


    @GetMapping("/v1/fund/etffunds/asset_top10")
    public List<EtfFundsListResponseDto> QfindTop10ByEtf_assets(){
        return etfFundsRepository.QfindTop10ByEtf_assets();
    }

    @GetMapping("/v1/fund/etffunds/findSearchName")
    public List<EtfFundsListResponseDto> QfindSearchName(EtfFundsNameDto condition){
        List<EtfFundsListResponseDto> etfList = etfFundsRepository.QfindSearchName(condition);

        if(etfList.isEmpty()){
            throw new NotFoundException(String.format("name[%s] not found",condition));
        }

        return etfList;
    }

    @GetMapping("/v1/fund/etffunds/findSearchBasic_Index")
    public List<EtfFundsListResponseDto> QfindSearchBasic_Index(EtfFundsbasicIndexDto condition){
        List<EtfFundsListResponseDto> etfList = etfFundsRepository.QfindSearchBasic_Index(condition);

        if(etfList.isEmpty()){
            throw new NotFoundException(String.format("basic_index [%s] not found",condition));
        }

        return etfList;
    }




}
