package com.example.BigK.controller;

import com.example.BigK.dto.EmailMessage;
import com.example.BigK.dto.EmailPostDto;
import com.example.BigK.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class EmailController {
  private final EmailService emailService;
  @PostMapping("/send")
  public String send(@ModelAttribute EmailPostDto emailPostDto){
    System.out.println(emailPostDto.getEmail());
    EmailMessage emailMessage = EmailMessage.builder()
        .to(emailPostDto.getEmail())
        .subject("[BigK] 신규 공고 알림")
        .build();

    emailService.sendMail(emailMessage);

    return "home";
  }

}
