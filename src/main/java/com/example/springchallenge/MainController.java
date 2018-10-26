package com.example.springchallenge;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
public class MainController {

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping("/")
    public String HomePage(Model model) {
        model.addAttribute("accounts", accountRepository.findAll() );


        return "index";
    }
    @PostMapping("/process")
    public String processForm(@Valid Account account, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        accountRepository.save(account);
        return "redirect:/";
    }


    @RequestMapping("/deposit")
    public String depositForm(){


        return "depositPage";
    }

    @RequestMapping("/withdrawal")
    public String withdrawalForm(){

        return"withdrawalPage";
    }

    @RequestMapping("/showHistory")
    public String historyPage(){

        return "showHistory";
    }
}
