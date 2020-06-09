package com.dmc.oauth2.api;

import com.dmc.oauth2.domain.event.Event;
import com.dmc.oauth2.domain.event.EventRepository;
import com.dmc.oauth2.domain.event.dto.EventCategorySearchCondition;
import com.dmc.oauth2.domain.event.dto.EventListResponseDto;
import com.dmc.oauth2.domain.event.dto.EventNameSearchCondition;
import com.dmc.oauth2.domain.news.News;
import com.dmc.oauth2.domain.news.NewsRepository;
import com.dmc.oauth2.domain.news.NewsRepositoryCustom;
import com.dmc.oauth2.domain.news.dto.NewsCategorySearchCondition;
import com.dmc.oauth2.domain.news.dto.NewsListResponseDto;
import com.dmc.oauth2.domain.news.dto.NewsNameSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final EventRepository eventRepository;
    private final NewsRepository newsRepository;



    @GetMapping("/v1/event")
    public List<Event> findAll(){
        return eventRepository.findAll();
    }

    @GetMapping("/v1/event/searchByName")
    public List<EventListResponseDto> searchByName(EventNameSearchCondition condition){
        return eventRepository.searchByName(condition);
    }

    @GetMapping("/v1/event/searchByCategory")
    public List<EventListResponseDto> searchByCategory(EventCategorySearchCondition condition){
        return eventRepository.searchByCategory(condition);
    }

    @GetMapping("/v1/news")
    public List<News> NewsFindAll(){
        return newsRepository.findAll();
    }

    @GetMapping("/v1/news/searchByName")
    public List<NewsListResponseDto> searchByName(NewsNameSearchCondition condition){
        return newsRepository.searchByName(condition);
    }

    @GetMapping("/v1/news/searchByCategory")
    public List<NewsListResponseDto> searchByCategory(NewsCategorySearchCondition condition){
        return newsRepository.searchByCategory(condition);
    }


}
