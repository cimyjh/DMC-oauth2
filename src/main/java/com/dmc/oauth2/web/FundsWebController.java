package com.dmc.oauth2.web;

import com.dmc.oauth2.domain.koreaFunds.KoreaFunds;
import com.dmc.oauth2.service.KoreaFundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FundsWebController {

    @Autowired
    private KoreaFundsService koreaFundsService;


    @GetMapping("/koreafunds")
    public String koreafunds(@PageableDefault Pageable pageable, Model model){
        Page<KoreaFunds> list= koreaFundsService.getKoreaFundsList(pageable);
        model.addAttribute("koreafunds", list);
        return "koreafunds";
    }


}
