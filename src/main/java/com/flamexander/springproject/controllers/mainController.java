package com.flamexander.springproject.controllers;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ComponentScan
public class mainController {

    @GetMapping("/main")
    public String showPage() {
        return "mainPage";
    }

}
