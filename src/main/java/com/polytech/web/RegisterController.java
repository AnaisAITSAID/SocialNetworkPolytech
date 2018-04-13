package com.polytech.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerPage(){
        return ("/register");
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String register(String username, String password){
        
    }
}
