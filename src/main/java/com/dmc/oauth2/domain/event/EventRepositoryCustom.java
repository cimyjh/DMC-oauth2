package com.dmc.oauth2.domain.event;


import com.dmc.oauth2.domain.event.dto.EventCategorySearchCondition;
import com.dmc.oauth2.domain.event.dto.EventListResponseDto;
import com.dmc.oauth2.domain.event.dto.EventNameSearchCondition;

import java.util.List;

public interface EventRepositoryCustom {
    List<EventListResponseDto> searchByName(EventNameSearchCondition condition);

    List<EventListResponseDto> searchByCategory(EventCategorySearchCondition condition);

    List<EventListResponseDto> findAllDto();

}
