package com.dmc.oauth2.web;

import com.dmc.oauth2.domain.koreaFunds.KoreaFunds;
import com.dmc.oauth2.domain.koreaFunds.KoreaFundsRepository;
import com.dmc.oauth2.domain.koreaFunds.dto.KoreaFundsListResponseDto;
import com.dmc.oauth2.service.KoreaFundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FundsWebController {

    @Autowired
    private KoreaFundsService koreaFundsService;

    @Autowired
    private KoreaFundsRepository koreaFundsRepository;


    @GetMapping("/koreafunds")
    public String koreafunds(@PageableDefault Pageable pageable, Model model){
        Page<KoreaFunds> list= this.koreaFundsService.getKoreaFundsList(pageable);
        model.addAttribute("koreafunds", list);
        return "koreafunds";
    }


    @GetMapping("/koreafundsTop10/3y")
    public String KoreadFundsTop10(Model model){
        List<KoreaFundsListResponseDto> list = this.koreaFundsService.KoreaFundsTop10();
        model.addAttribute("koreafunds",list);
        return "exkoreafundsTop10";
    }

    @GetMapping("/koreafundsTop10/asset")
    public String findTop10ByFund_assets(Model model){
        List<KoreaFundsListResponseDto> list = this.koreaFundsService.findTop10ByFund_assets();
        model.addAttribute("koreafunds",list);
        return "koreafundsTop10";
    }

    @GetMapping("/koreafundsTop10/searchName")
    public String QfindSearchName(@RequestParam(value = "fund_name")String fund_name, Model model){
        List<KoreaFundsListResponseDto> list = this.koreaFundsService.findSearchName(fund_name);
        model.addAttribute("koreafunds",list);
        return "koreafundsTop10";
    }


    @GetMapping("/koreafundsTop10/searchType")
    public String QfindSearchType(@RequestParam(value = "fund_type")String fund_type,Model model){
        List<KoreaFundsListResponseDto> list = koreaFundsService.findSearchType(fund_type);
        model.addAttribute("koreafunds",list);
        return "koreafundsTop10";
    }



    @GetMapping("/pkoreafundsTop10/searchName")
    public String PfindSearchName(@RequestParam(value = "fund_name")String fund_name, Model model){


        List<KoreaFundsListResponseDto> list = this.koreaFundsService.findSearchName(fund_name);
        model.addAttribute("koreafunds",list);
        return "koreafundsTop10";
    }


    @GetMapping("/pkoreafundsTop10/searchType")
    public String PfindSearchType(@RequestParam(value = "fund_type")String fund_type,Model model){
        List<KoreaFundsListResponseDto> list = koreaFundsService.findSearchType(fund_type);
        model.addAttribute("koreafunds",list);
        return "koreafundsTop10";
    }
}
