package com.dmc.oauth2.domain.etfFunds;


import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsListResponseDto;
import com.dmc.oauth2.domain.etfFunds.EtfFunds;
import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsNameDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EtfFundsRepositoryTest {

//    @Autowired
//    private EtfFundsRepository etfFundsRepository;
//
//    @Test
//    void findAll(){
//        List<EtfFunds> etf = etfFundsRepository.findAll();
//
//        then(!etf.isEmpty());
//
//    }
//
//    //DTO가 잘 작동하나 확인.
//    @Test
//    void findOne(){
//
//        List<EtfFundsListResponseDto> etf = etfFundsRepository.findAllDto();
//
//        then(!etf.isEmpty());
//
//    }


    //condtion에 뭐가 들어가야 하지??
    //인프런 예시 pdf봐야 한다.
//    @Test
//    void findSearchName(){
//
//        List<EtfFundsListResponseDto> etf = etfFundsRepository.QfindSearchName(EtfFundsNameDto.class.getTypeName().("하나"));
//
//        then(!etf.isEmpty());
//
//    }



}