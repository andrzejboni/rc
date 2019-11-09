package com.pact.rentcar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizationController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "authorization/login"; // 03/14:44
    }
}
