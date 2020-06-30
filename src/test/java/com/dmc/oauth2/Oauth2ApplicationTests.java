package com.dmc.oauth2;

import com.dmc.oauth2.domain.koreaFunds.KoreaFunds;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.dmc.oauth2.domain.koreaFunds.QKoreaFunds;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static com.dmc.oauth2.domain.koreaFunds.QKoreaFunds.*;


@SpringBootTest
@Transactional
class Oauth2ApplicationTests {

	@PersistenceContext
	EntityManager em;

	JPAQueryFactory queryFactory;

//	@Autowired
//	KoreaFundsRepository koreaFundsRepository;
//
//	@Autowired
//	KoreaFundsListResponseDto koreaFundsListResponseDto;
//
//	@Autowired
//	KoreaFunds koreaFunds;

	@BeforeEach
	public void before(){
		queryFactory = new JPAQueryFactory(em);
		KoreaFunds koreaFundsA = new KoreaFunds(5555L,"하나U별자산 3 ClassC1", "부동산대출채권", "2007/08", (float) 177.56, 50L, 188L);
		em.persist(koreaFundsA);
	}

	@Test
	public void searchTest(){

		QKoreaFunds m = new QKoreaFunds("m");

		KoreaFunds findKoreaFunds = queryFactory
				.select(m)
				.from(m)
				.where(m.fund_name.eq("신영프라임배당[주식]종류C1"))
				.fetchOne();

		assertThat(findKoreaFunds.getFund_name()).isEqualTo("신영프라임배당[주식]종류C1");
	}

	@Test
	public void searchAndparam(){
		List<KoreaFunds> result1 = queryFactory
				.selectFrom(koreaFunds)
				.fetch();
		assertThat(result1.size()).isEqualTo(927);
	}

}
