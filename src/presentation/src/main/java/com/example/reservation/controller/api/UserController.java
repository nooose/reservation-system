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

    /**
     * 특정 회원 조회
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public ResponseUserDto getMember(@PathVariable Long userId) {
        User user = (User) userService.getMember(userId);

        return user.toResponseDto();
    }

    /**
     * 모든 회원 조회
     * @return
     */
    @GetMapping("/users")
    public List<ResponseUserDto> getMembers() {
        List<Member> members = userService.getMembers();

        return members.stream()
                .map(m -> (User) m)
                .map(User::toResponseDto)
                .collect(Collectors.toList());
    }

    /**
     * 특정 회원 정보 수정
     * @param userId
     * @param requestUserDto
     * @return
     */
    @PutMapping("/{userId}")
    public ResponseUserDto updateUser(@PathVariable Long userId, @RequestBody RequestUserDto requestUserDto) {
        userService.update(userId, requestUserDto.toEntity());

        User findUser = (User) userService.getMember(userId);
        return findUser.toResponseDto();
    }

    /**
     * 회원 생성
     * @param requestUserDto
     * @return
     */
    @PostMapping
    public ResponseUserDto saveUser(@RequestBody RequestUserDto requestUserDto) {
        User user = requestUserDto.toEntity();
        userService.join(user);

        User findUser = (User) userService.getMember(user.getId());
        return findUser.toResponseDto();
    }

    /**
     * 특정 회원 삭제
     * @param userId
     * @return
     */
    @DeleteMapping("/{userId}")
    public String removeUser(@PathVariable Long userId) {
        userService.remove(userId);

        return "삭제 되었습니다.";
    }



}

