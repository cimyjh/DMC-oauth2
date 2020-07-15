package com.dmc.oauth2.domain.etfFunds;

import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsListResponseDto;
import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsNameDto;
import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsbasicIndexDto;
import com.dmc.oauth2.domain.etfFunds.dto.QEtfFundsListResponseDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;
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

    @Override
    public List<EtfFundsListResponseDto> QfindTop10ByEtf_1wY() {
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
                .orderBy(etfFunds.etf_1wY.desc())
                .limit(10)
                .fetch();
    }

    @Override
    public List<EtfFundsListResponseDto> QfindTop10ByEtf_1mY() {
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
                .orderBy(etfFunds.etf_1mY.desc())
                .limit(10)
                .fetch();
    }

    @Override
    public List<EtfFundsListResponseDto> QfindTop10ByEtf_3mY() {
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
                .orderBy(etfFunds.etf_3mY.desc())
                .limit(10)
                .fetch();
    }

    @Override
    public List<EtfFundsListResponseDto> QfindTop10ByEtf_1dV() {
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
                .orderBy(etfFunds.etf_1d_volume.desc())
                .limit(10)
                .fetch();
    }

    @Override
    public List<EtfFundsListResponseDto> QfindTop10ByEtf_assets() {
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
                .orderBy(etfFunds.etf_assets.desc())
                .limit(10)
                .fetch();
    }



    @Override
    public List<EtfFundsListResponseDto> QfindSearchName(EtfFundsNameDto condition) {
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
                .where(etfNameContains(condition.getEtf_name()))
                .fetch();
    }

    @Override
    public List<EtfFundsListResponseDto> QfindSearchBasic_Index(EtfFundsbasicIndexDto condition) {
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
                .where(etfBasic_IndexContains(condition.getEtf_basic_index()))
                .fetch();
    }


    private BooleanExpression etfNameContains(String name){
        return isEmpty(name) ? null : etfFunds.etf_name.contains(name);
    }

    private BooleanExpression etfBasic_IndexContains(String basic_index){
        return isEmpty(basic_index) ? null : etfFunds.etf_basic_index.contains(basic_index);
    }

}
