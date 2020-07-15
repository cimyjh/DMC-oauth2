package com.dmc.oauth2.web;

import com.dmc.oauth2.domain.etfFunds.EtfFunds;
import com.dmc.oauth2.domain.etfFunds.EtfFundsRepository;
import com.dmc.oauth2.domain.etfFunds.dto.EtfFundsListResponseDto;
import com.dmc.oauth2.service.EtfFundsService;
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
public class EtfFundsWebController {

    @Autowired
    private EtfFundsService etfFundsService;

    @Autowired
    private EtfFundsRepository etfFundsRepository;

    @GetMapping("/etffunds")
    public String etffunds(@PageableDefault Pageable pageable, Model model){
        Page<EtfFunds> list= this.etfFundsService.getEtfFundsList(pageable);
        model.addAttribute("etffunds", list);
        return "etffunds";
    }


    @GetMapping("/etffundsTop10/1w")
    public String EtfFunds1wTop10(Model model){
        List<EtfFundsListResponseDto> list = this.etfFundsService.etfFunds1wyTop10();
        model.addAttribute("etffunds",list);
        return "etffundsTop10";
    }

    @GetMapping("/etffundsTop10/1m")
    public String EtfFunds1mTop10(Model model){
        List<EtfFundsListResponseDto> list = this.etfFundsService.etfFunds1myTop10();
        model.addAttribute("etffunds",list);
        return "etffundsTop10";
    }

    @GetMapping("/etffundsTop10/3m")
    public String EtfFunds3mTop10(Model model){
        List<EtfFundsListResponseDto> list = this.etfFundsService.etfFunds3myTop10();
        model.addAttribute("etffunds",list);
        return "etffundsTop10";
    }

    @GetMapping("/etffundsTop10/asset")
    public String EtfFundsAssetTop10(Model model){
        List<EtfFundsListResponseDto> list = this.etfFundsService.etfFundsAssetTop10();
        model.addAttribute("etffunds",list);
        return "etffundsTop10";
    }

    @GetMapping("/etffunds/searchName")
    public String etfFindSearchName(@RequestParam(value = "etf_name")String etf_name, Model model){
        List<EtfFundsListResponseDto> list = this.etfFundsService.findSearchName(etf_name);
        model.addAttribute("etffunds",list);
        return "etffundsTop10";
    }


    @GetMapping("/etffunds/searchBasicIndex")
    public String etfFindSearchType(@RequestParam(value = "etf_basic_index")String etf_basic_index,Model model){
        List<EtfFundsListResponseDto> list = etfFundsService.findSearchType(etf_basic_index);
        model.addAttribute("etffunds",list);
        return "etffundsTop10";
    }
}
