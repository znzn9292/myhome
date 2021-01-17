package com.znzn.mythymeleaf.controller;

import com.znzn.mythymeleaf.model.User;
import com.znzn.mythymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String login(){
        return "account/login";
    }

    @GetMapping(value = "/register")
    public String register(){
        return "account/register";
    }

    @PostMapping(value = "/register")
    public String register(User user){
        userService.save(user);
        return "redirect:/";
    }

}
