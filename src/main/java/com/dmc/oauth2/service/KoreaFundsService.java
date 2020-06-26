package com.dmc.oauth2.service;

import com.dmc.oauth2.domain.koreaFunds.KoreaFunds;
import com.dmc.oauth2.domain.koreaFunds.KoreaFundsRepository;
import com.dmc.oauth2.domain.koreaFunds.KoreaFundsRepositoryImpl;
import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsListResponseDto;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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


//    public List<KoreaFundsListResponseDto> KoreadFundsTop10(){
//        return koreaFundsRepositoryImpl.QfindTop10ByFund_3y();
//
//    }



}
