package com.example.reservation.controller.api;

import com.example.reservation.domain.dto.RequestUserDto;
import com.example.reservation.domain.dto.ResponseUserDto;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.entity.User;
import com.example.reservation.service.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/{userId}")
    public ResponseUserDto getMember(@PathVariable Long userId) {
        User user = (User) userService.getMember(userId);

        return user.toResponseDto();
    }

    @GetMapping("/users")
    public List<ResponseUserDto> getMembers() {
        List<Member> members = userService.getMembers();

        return members.stream()
                .map(m -> (User) m)
                .map(User::toResponseDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{userId}")
    public ResponseUserDto updateUser(@PathVariable Long userId, @RequestBody RequestUserDto requestUserDto) {
        userService.update(userId, requestUserDto.toEntity());

        User findUser = (User) userService.getMember(userId);
        return findUser.toResponseDto();
    }

    @PostMapping
    public ResponseUserDto saveUser(@RequestBody RequestUserDto requestUserDto) {
        User user = requestUserDto.toEntity();
        userService.join(user);

        User findUser = (User) userService.getMember(user.getId());
        return findUser.toResponseDto();
    }

    @DeleteMapping("/{userId}")
    public String removeUser(@PathVariable Long userId) {
        userService.remove(userId);

        return "삭제 되었습니다.";
    }


}

