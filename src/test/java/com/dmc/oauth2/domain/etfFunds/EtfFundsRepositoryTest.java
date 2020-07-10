package com.dmc.oauth2.domain.etfFunds;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EtfFundsRepositoryTest {

    @Autowired
    private EtfFundsRepository etfFundsRepository;


//    @Test
//    public void findAllEtf{
//        final Etf findAllEtf = etfFundsRepository.findAllDto();
//        assert(findAllEtf.get)
//
//    }

}