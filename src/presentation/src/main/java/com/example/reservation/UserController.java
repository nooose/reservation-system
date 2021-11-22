package com.example.reservation;

import com.example.reservation.domain.dto.UserDto;
import com.example.reservation.domain.entity.User;
import com.example.reservation.service.Impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

//    @GetMapping("/user")
//    public List<User> getAllUser() {
//    }
//
//
//    @GetMapping("/user/{userId}")
//    public String getUser(@PathVariable Long userId) {
//    }

    @PostMapping("/user")
    public String setUser(@RequestBody UserDto userDto) {
        User user = userDto.toEntity();
        userService.joinMember(user);

        return user + "\n가입 " + user.getSaveStatus();
    }
}

