package com.zerock.guestbook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/layout")
@RequiredArgsConstructor
public class SampleController {

    @GetMapping("/layout1")
    public void ex1(){

        log.info("ex1..........");
    }
}
