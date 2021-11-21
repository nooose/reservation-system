package com.example.reservation;

import com.example.reservation.domain.dto.UserDto;
import com.example.reservation.domain.entity.User;
import com.example.reservation.service.Impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUser() {
        return userService.findUsers();
    }


    @GetMapping("/user/{userId}")
    public String getUser(@PathVariable Long userId) {
        User userById = userService.findUserById(userId);

        if (userById.isNull()) {
            return "해당 유저가 없습니다.";
        } else {
            return userById.toString();
        }
    }

    @PostMapping("/user")
    public String setUser(@RequestBody UserDto userDto) {
        User newUser = userService.joinUser(userService.userToEntity(userDto));

        if (newUser.isNull()) {
            return "생성되지 않았습니다.";
        } else {
            return newUser + "생성 되었습니다.";
        }
    }
}

