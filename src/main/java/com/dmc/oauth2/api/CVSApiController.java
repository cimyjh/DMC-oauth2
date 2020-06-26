package com.dmc.oauth2.api;

import com.dmc.oauth2.apiException.NotFoundException;
import com.dmc.oauth2.domain.event.EventRepository;
import com.dmc.oauth2.domain.event.dto.EventCategorySearchCondition;
import com.dmc.oauth2.domain.event.dto.EventListResponseDto;
import com.dmc.oauth2.domain.event.dto.EventNameSearchCondition;
import com.dmc.oauth2.domain.news.NewsRepository;
import com.dmc.oauth2.domain.news.dto.NewsCategorySearchCondition;
import com.dmc.oauth2.domain.news.dto.NewsListResponseDto;
import com.dmc.oauth2.domain.news.dto.NewsNameSearchCondition;
import com.dmc.oauth2.domain.review.DetailRepository;
import com.dmc.oauth2.domain.review.dto.ReviewListResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CVSApiController {

    private final EventRepository eventRepository;
    private final NewsRepository newsRepository;
    private final DetailRepository detailRepository;


    @ApiOperation(value = "이벤트 상품 전체조회", notes = "모든 이벤트 상품을 조회한다.")
    @GetMapping("/v1/event")
    public List<EventListResponseDto> findAll(){
        return eventRepository.findAllDto();
    }

    @ApiOperation(value = "이벤트 상품명 검색", notes = "이벤트 상품의 이름을 검색하여 조회한다.")
    @GetMapping("/v1/event/searchByName")
    public List<EventListResponseDto> searchByName(EventNameSearchCondition condition){
        List<EventListResponseDto> eventList = eventRepository.searchByName(condition);

        if(eventList.isEmpty()){
            throw new NotFoundException(String.format("name[%s] not found",condition));
        }

        return eventList;
    }

    @ApiOperation(value = "이벤트 상품 카테고리 검색", notes = "이벤트 상품의 카테고리를 검색하여 조회한다.")
    @GetMapping("/v1/event/searchByCategory")
    public List<EventListResponseDto> searchByCategory(EventCategorySearchCondition condition){
        List<EventListResponseDto> eventList = eventRepository.searchByCategory(condition);

        if(eventList.isEmpty()){
            throw new NotFoundException(String.format("name[%s] not found", condition));
        }

        return eventList;
    }

    @ApiOperation(value = "신상품 전체조회", notes = "모든 신상품을 조회한다.")
    @GetMapping("/v1/news")
    public List<NewsListResponseDto> NewsFindAll(){
        return newsRepository.findAllDto();
    }


    @ApiOperation(value = "신상품 상품명 검색", notes = "신상품의 이름을 검색하여 조회한다.")
    @GetMapping("/v1/news/searchByName")
    public List<NewsListResponseDto> searchByName(NewsNameSearchCondition condition){
        List<NewsListResponseDto> newsList = newsRepository.searchByName(condition);

        if(newsList.isEmpty()){
            throw new NotFoundException(String.format("name[%s] not found", condition));
        }

        return newsList;
    }


    @ApiOperation(value = "신상품 카테고리 검색", notes = "신상품의 카테고리를 검색하여 조회한다.")
    @GetMapping("/v1/news/searchByCategory")
    public List<NewsListResponseDto> searchByCategory(NewsCategorySearchCondition condition){
        List<NewsListResponseDto> newsList = newsRepository.searchByCategory(condition);

        if(newsList.isEmpty()){
            throw new NotFoundException(String.format("name[%s] not found", condition));
        }

        return newsList;
    }

    @ApiOperation(value = "리뷰 전체조회", notes = "모든 리뷰를 조회한다.")
    @GetMapping("/v1/review")
    public List<ReviewListResponseDto> ReveiwFindAll(){
        return detailRepository.findAllDto();
    }

}
