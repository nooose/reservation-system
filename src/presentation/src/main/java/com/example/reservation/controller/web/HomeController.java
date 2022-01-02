package com.example.reservation.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/home")
@Controller
public class HomeController {

    @GetMapping
    public String Index(){
        return "home/index";
    }
}
