package com.dmc.oauth2.web;

import java.util.List;

import com.dmc.oauth2.config.auth.LoginUser;
import com.dmc.oauth2.config.auth.dto.SessionUser;
import com.dmc.oauth2.domain.user.UserRepository;
import com.dmc.oauth2.service.DetailService;
import com.dmc.oauth2.service.EventService;
import com.dmc.oauth2.service.NewsService;
import com.dmc.oauth2.service.PostsService;
import com.dmc.oauth2.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dmc.oauth2.domain.review.Review;
import com.dmc.oauth2.domain.event.Event;
import com.dmc.oauth2.domain.news.News;
import com.dmc.oauth2.service.EventService;
import com.dmc.oauth2.service.NewsService;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@Controller
public class IndexController {

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

    @GetMapping("/new")
    public String news(@PageableDefault Pageable pageable, Model model) {
        Page<News> list = newsService.getNewsList(pageable);
        model.addAttribute("news", list);
        return "new_paging";
    }


    @GetMapping("/new/{store}")
    public String news(@PathVariable String store, Model model) {
        List<News> list = newsService.findByStore(store);
        model.addAttribute("news", list);
        return "new"; // templates/display.html
    }


    //페이징
    @GetMapping("/event")
    public String event(@PageableDefault Pageable pageable, Model model) {

        Page<Event> list = eventService.getEventList(pageable);
        model.addAttribute("events", list);

//		Page<BoardEntity> boardList = boardService.getBoardList(pageable);
//		model.addAttribute("boardList", boardList);

//		List<Event> list = eventService.findEvents();
//		model.addAttribute("events", list);
        return "event_paging";
    }




    @GetMapping("/event/{store}")
    public String event(@PathVariable String store, Model model) {

        //페이징을 하려면 service - repository를 설계해야 한다.
//		Page<Event> list = eventService.getEventList(pageable);
//		model.addAttribute("events", list);


        List<Event> list = eventService.findByStore(store);
        model.addAttribute("events", list);

        return "event"; // templates/display.html

    }


    // detail
    @GetMapping("/detail/{newsNum}")
    public String detail(@PathVariable Long newsNum, Model model) {

        News news = newsService.findByNewsNum(newsNum);
        model.addAttribute("news", news);

        List<Review> list = detailService.findReviewByNews(newsNum);
        model.addAttribute("reviews", list);

        return "detail";
    }


    //시도 하고 있는 것
    @GetMapping("/review/{newsNum}")
    public String review(@PathVariable long newsNum,
                         @RequestParam(value = "reviewComment") String reviewComment,
                         @RequestParam(value = "reviewLike") String reviewLike,
                         @LoginUser SessionUser user
    ) {

        String name = user.getName();
        detailService.insertReview(newsNum, name, reviewComment, reviewLike);


        return "redirect:/detail/{newsNum}";
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
