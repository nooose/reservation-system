package com.example.reservation.service.Impl;

import com.example.reservation.domain.entity.User;
import com.example.reservation.domain.service.MemberDomainService;
import com.example.reservation.domain.service.UserDomainService;
import com.example.reservation.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final MemberDomainService memberDomainService;
    private final UserDomainService userDomainService;

    public UserServiceImpl(MemberDomainService memberDomainService, UserDomainService userDomainService) {
        this.memberDomainService = memberDomainService;
        this.userDomainService = userDomainService;
    }

    public List<User> getAllUsers() {
        List<User> users = userDomainService.getUsers();
        String usersCount = userDomainService.getUsersCount(users);

        log.info("{}명 조회 완료", usersCount);
        return users;
    }

    public String getUser(Long id) {
        User user = userDomainService.findUserById(id);
        return userDomainService.getUserStatus(user);
    }

    public void joinMember(User user) {
        boolean isEmail = memberDomainService.checkEmail(user.getEmail());
        boolean isPhoneNumber = memberDomainService.checkPhoneNumber(user.getPhoneNumber());

        User newUser = memberDomainService.saveUser(user, isEmail, isPhoneNumber);

        String saveStatus = newUser.getSaveStatus();
        log.info("{} 회원 가입 {}", user.getEmail(), saveStatus );
    }

    public String deleteUser(Long id) {
        User user = userDomainService.findUserById(id);
        return userDomainService.deleteUser(user);
    }

    public User updateUser(User newUser, Long id){

        User oldUser = userDomainService.findUserById(id);

    return userDomainService.updateUser(newUser,oldUser);
    }

 }
