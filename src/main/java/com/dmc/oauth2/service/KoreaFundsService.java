package com.dmc.oauth2.service;

import com.dmc.oauth2.domain.koreaFunds.KoreaFunds;
import com.dmc.oauth2.domain.koreaFunds.KoreaFundsRepository;
import com.dmc.oauth2.domain.koreaFunds.KoreaFundsRepositoryImpl;
import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsListResponseDto;
import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsNameDto;
import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KoreaFundsService {

    @Autowired
    private KoreaFundsRepository koreaFundsRepository;

    @Autowired
    private KoreaFundsRepositoryImpl koreaFundsRepositoryImpl;


    public Page<KoreaFunds> getKoreaFundsList(Pageable pageable){
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page,20);
        return koreaFundsRepository.findAll(pageable);
    }


    public List<KoreaFundsListResponseDto> KoreaFundsTop10(){
        return koreaFundsRepository.QfindTop10ByFund_3y();
    }


    public List<KoreaFundsListResponseDto> findTop10ByFund_assets(){
        return koreaFundsRepository.QfindTop10ByFund_assets();
    }


    public List<KoreaFundsListResponseDto> findSearchName(String fund_name){

        KoreaFundsNameDto condition = new KoreaFundsNameDto();
        condition.setFund_name(fund_name);

        return koreaFundsRepository.QfindSearchName(condition);
    }


    public List<KoreaFundsListResponseDto> findSearchType(String fund_type){

        KoreaFundsTypeDto condition = new KoreaFundsTypeDto();
        condition.setFund_type(fund_type);

        return koreaFundsRepository.QfindSearchType(condition);
    }
}
