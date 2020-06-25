package com.dmc.oauth2.domain.koreaFunds;

import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsListResponseDto;
import com.dmc.oauth2.domain.koreaFunds.dto.QKoreaFundsListResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static com.dmc.oauth2.domain.koreaFunds.QKoreaFunds.koreaFunds;

public class KoreaFundsRepositoryImpl implements KoreaFundsRepositoryCustom {


    private final JPAQueryFactory queryFactory;

    public KoreaFundsRepositoryImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<KoreaFundsListResponseDto> findAllDto() {
        return queryFactory
                .select(new QKoreaFundsListResponseDto(
                        koreaFunds.fund_num,
                        koreaFunds.fund_name,
                        koreaFunds.fund_type,
                        koreaFunds.fund_start_date,
                        koreaFunds.fund_3y,
                        koreaFunds.fund_assets,
                        koreaFunds.fund_scale_operation))
                .from(koreaFunds)
                .fetch();

    }
}
