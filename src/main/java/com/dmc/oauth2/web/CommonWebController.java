package com.dmc.oauth2.web;

import java.util.List;

import com.dmc.oauth2.config.auth.LoginUser;
import com.dmc.oauth2.config.auth.dto.SessionUser;
import com.dmc.oauth2.domain.event.dto.EventListResponseDto;
import com.dmc.oauth2.domain.news.dto.NewsListResponseDto;
import com.dmc.oauth2.domain.user.UserRepository;
import com.dmc.oauth2.service.DetailService;
import com.dmc.oauth2.service.EventService;
import com.dmc.oauth2.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dmc.oauth2.domain.review.Review;
import com.dmc.oauth2.domain.event.Event;
import com.dmc.oauth2.domain.news.News;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CommonWebController {

    @Autowired
    private EventService eventService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private DetailService detailService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    public String index() {

        return "index"; // templates/index.html
    }


    // 로그인 결과 페이지
    @GetMapping("/loginSuccess")
    public String dispLoginResult() {
        return "/loginSuccess";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/logout")
    public String dispLogout() {
        return "/logout";
    }

    // 접근 거부 페이지
    @GetMapping("/accessDenied")
    public String dispDenied() {
        return "/accessDenied";
    }


}
