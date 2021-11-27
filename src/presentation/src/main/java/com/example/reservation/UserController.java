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
        return userService.getAllUsers();
    }


    @GetMapping("/user/{userId}")
    public String getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/user")
    public String createUser(@RequestBody UserDto userDto) {
        User user = userDto.toEntity();
        userService.joinMember(user);

        return user + "\n가입 " + user.getSaveStatus();
    }


    @PostMapping("/user/update/{userId}")
    public String setUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
        User updateUser = userService.updateUser(userId, userDto);

        log.info("업데이트 완료");
        return updateUser + "\n업데이트 되었습니다" ;
    }

    @PostMapping("/user/delete/{userId}")
    public String deletUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }



}

