package com.dmc.oauth2.domain.koreaFunds;

import com.dmc.oauth2.domain.koreaFunds.KoreaFunds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KoreaFundsRepository extends JpaRepository<KoreaFunds, Long>, KoreaFundsRepositoryCustom {

}
