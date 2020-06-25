package com.dmc.oauth2.domain.etfFunds;

import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsListResponseDto;
import com.dmc.oauth2.domain.etfFunds.dto.QEtfFundsListResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static com.dmc.oauth2.domain.etfFunds.QEtfFunds.etfFunds;

public class EtfFundsRepositoryImpl implements EtfFundsRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public EtfFundsRepositoryImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<EtfFundsListResponseDto> findAllDto() {
        return queryFactory
                .select(new QEtfFundsListResponseDto(
                        etfFunds.etf_num,
                        etfFunds.etf_name,
                        etfFunds.etf_basic_index,
                        etfFunds.etf_close,
                        etfFunds.etf_assets,
                        etfFunds.etf_1dY,
                        etfFunds.etf_1wY,
                        etfFunds.etf_1mY,
                        etfFunds.etf_3mY,
                        etfFunds.etf_1d_volume))
                .from(etfFunds)
                .fetch();
    }

}
