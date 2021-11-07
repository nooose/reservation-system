package com.example.reservation.controller;

import com.example.reservation.service.Impl.UserServiceImplV1;
import com.example.reservation.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {

    private final UserService userService;

    public testController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String saveUser() {
        userService.testSaveUser();
        return "OK";
    }

    @GetMapping("/test1")
    public String test1() {
        userService.testSaveuser2();
        return "OK-2";
    }

    @GetMapping("/test2")
    public String test2() {
        userService.testSaveuser3();
        return "OK-3";
    }
}
