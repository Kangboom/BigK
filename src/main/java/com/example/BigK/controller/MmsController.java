package com.example.BigK.controller;

import com.example.BigK.dto.MmsDto;
import com.example.BigK.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mms")
public class MmsController {

  private final EmailService mmsService;

  @PostMapping("/save")
  public MmsDto saveOrUpdateMms(@RequestBody MmsDto mmsDto) {
    mmsService.saveOrUpdateMms(mmsDto);
    return mmsDto;
  }
}
