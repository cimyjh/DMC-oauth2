package com.dmc.oauth2.domain.koreaFunds;

import com.dmc.oauth2.domain.koreaFunds.KoreaFunds;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KoreaFundsRepository extends JpaRepository<KoreaFunds, Long>, KoreaFundsRepositoryCustom {
    List<KoreaFunds> findTop10ByOrderByFund3yDesc();

}
