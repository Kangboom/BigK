package com.example.BigK.controller;

import com.example.BigK.dto.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/home")
    public String home() { return "home"; }
    @GetMapping("/oauth")
    public String oauth(){
        return "oauth";
    }


    @GetMapping("/alarm")
    public String alarm() { return "alarm"; }

}
