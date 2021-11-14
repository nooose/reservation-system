package com.example.reservation.controller;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.entity.User;
import com.example.reservation.service.Impl.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/save")
    public void saveTest() {
        Address address = userService.createAddress("서울", "동남로", "123-456");
        User user = userService.createUser("test@test.com", "123456"
                , "테스트", "테스트"
                , address, "010-1234-5678");

        userService.saveUser(user);
    }

    @GetMapping("/find/{userId}")
    public String findTest(@PathVariable Long userId) {
        User findUser = userService.findUserById(userId);
        return userService.isNullUser(findUser);
    }

    @GetMapping("/update/{userId}/{nickName}")
    public String findTest(@PathVariable Long userId, @PathVariable String nickName) {
        User findUser = userService.findUserById(userId);
        userService.updateUserNickName(findUser, nickName);
        return "변경 완료";
    }

    @GetMapping("/delete/{userId}")
    public String deleteTest(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

}
