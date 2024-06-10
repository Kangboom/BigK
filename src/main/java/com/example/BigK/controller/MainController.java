package com.example.BigK.controller;

import com.example.BigK.entity.User;
import com.example.BigK.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final UserService userService;
//    @GetMapping("/oauth")
//    public String oauth(){
//        return "oauth";
//    }
    @GetMapping(value = {"", "/"})
    public String home(@CookieValue(name= "userId", required = false) Long userId, Model model){
        User loginUser = userService.getLoginUserById(userId);

        if(loginUser != null){
            model.addAttribute("nickname", loginUser.getNickname());
        }
        else{
            model.addAttribute("nickname", null);
        }

        return "home";
    }
    @GetMapping("/mypage")
    public String mypage(){ return "mypage" ;}
    @GetMapping("/mms")
    public String mms(@CookieValue(name= "userId", required = false) Long userId, Model model) {
        User loginUser = userService.getLoginUserById(userId);

        if(loginUser != null){
            model.addAttribute("nickname", loginUser.getNickname());
        }
        else{
            return "redirect:/login";
        }
        return "mms";
    }

    @GetMapping("/notice")
    public String notice(@CookieValue(name= "userId", required = false) Long userId, Model model){
        User loginUser = userService.getLoginUserById(userId);

        if(loginUser != null){
            model.addAttribute("nickname", loginUser.getNickname());
        }
        else{
            return "redirect:/login";
        }
        return "notice";
    }

}
