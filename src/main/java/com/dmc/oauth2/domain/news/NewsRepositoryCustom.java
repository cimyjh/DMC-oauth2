package com.dmc.oauth2.domain.news;


import com.dmc.oauth2.domain.news.dto.NewsCategorySearchCondition;
import com.dmc.oauth2.domain.news.dto.NewsListResponseDto;
import com.dmc.oauth2.domain.news.dto.NewsNameSearchCondition;

import java.util.List;

public interface NewsRepositoryCustom {
    List<NewsListResponseDto> searchByName(NewsNameSearchCondition condition);

    List<NewsListResponseDto> searchByCategory(NewsCategorySearchCondition condition);

}
