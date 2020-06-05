package com.dmc.oauth2.domain.event;

import com.dmc.oauth2.domain.event.dto.EventListResponseDto;
import com.dmc.oauth2.domain.event.dto.EventNameSearchCondition;
import com.dmc.oauth2.domain.event.dto.QEventListResponseDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.dmc.oauth2.domain.event.Event;

import javax.persistence.EntityManager;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;
import static com.dmc.oauth2.domain.event.QEvent.event;



public class EventRepositoryImpl implements EventRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public EventRepositoryImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<EventListResponseDto> searchByName(EventNameSearchCondition condition) {
        return queryFactory
                .select(new QEventListResponseDto(
                        event.eventNum,
                        event.name,
                        event.price,
                        event.evt,
                        event.product1,
                        event.store,
                        event.product2,
                        event.img,
                        event.registerDate,
                        event.expireDate))
                .from(event)
                .where(eventNameEq(condition.getName()))
                .fetch();
    }



    private BooleanExpression eventNameEq(String name) {
        return isEmpty(name) ? null : event.name.contains(name);
    }



}
