package com.dmc.oauth2.domain.koreaFunds;

import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsListResponseDto;
import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsNameDto;
import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsTypeDto;
import com.dmc.oauth2.domain.koreaFunds.dto.QKoreaFundsListResponseDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static com.dmc.oauth2.domain.etfFunds.QEtfFunds.etfFunds;
import static com.dmc.oauth2.domain.koreaFunds.QKoreaFunds.koreaFunds;
import static org.springframework.util.StringUtils.isEmpty;

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

    @Override
    public List<KoreaFundsListResponseDto> QfindTop10ByFund_3y() {
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
                .orderBy(koreaFunds.fund_3y.desc())
                .limit(10)
                .fetch();
    }

    @Override
    public List<KoreaFundsListResponseDto> QfindTop10ByFund_assets() {
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
                .orderBy(koreaFunds.fund_assets.desc())
                .limit(10)
                .fetch();
    }

    @Override
    public List<KoreaFundsListResponseDto> QfindSearchName(KoreaFundsNameDto condition) {
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
                .where(koreaFundsNameContains(condition.getFund_name()))
                .fetch();
    }

    @Override
    public List<KoreaFundsListResponseDto> QfindSearchType(KoreaFundsTypeDto condition) {
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
                .where(koreaFundsTypeContains(condition.getFund_type()))
                .fetch();
    }



    private BooleanExpression koreaFundsNameContains(String name){
        return isEmpty(name) ? null : koreaFunds.fund_name.contains(name);
    }

    private BooleanExpression koreaFundsTypeContains(String type){
        return isEmpty(type) ? null : koreaFunds.fund_type.contains(type);
    }


}
