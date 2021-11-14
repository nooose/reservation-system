package com.example.reservation.service.Impl;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.enumtype.MemberRole;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.entity.User;
import com.example.reservation.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class UserService {
    private final MemberRepository memberRepository;

    public UserService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Address createAddress(String city, String street, String zipcode) {
        Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setZipcode(zipcode);

        return address;
    }

    public User createUser(String email, String password, String nickName, String name, Address address, String phoneNumber) {
        User user = User.builder()
                .email(email).password(password)
                .nickName(nickName).name(name)
                .address(address).phoneNumber(phoneNumber)
                .memberRole(MemberRole.BASIC).point(0).build();

        return user;
    }

    public User getEmptyUser() {
        User user = User.builder().build();
        return user;
    }


    public void saveUser(User user) {
        memberRepository.save(user);
    }

    
    @Transactional
    public void updateUserNickName(User user, String nickName) {
        Optional<Member> byId = memberRepository.findById(user.getId());
        User findUser = (User) byId.orElseGet(() -> getEmptyUser());

        findUser.changeNickName(nickName);
    }


    public User findUserById(Long id) {
        Optional<Member> findUser = memberRepository.findById(id);
        User user = (User) findUser.orElseGet(() -> getEmptyUser());

        return user;
    }

    public String deleteUser(Long id) {
        Optional<Member> findUser = memberRepository.findById(id);
        User user = (User) findUser.orElseGet(() -> getEmptyUser());

        if ( !user.isNull() ) {
            memberRepository.delete(user);
            return "삭제 완료";
        } else {
            return "해당 유저가 없습니다.";
        }
    }


    public String isNullUser(User user) {
        if( user.isNull() ) {
            return "유저가 없습니다.";
        } else {
            return user.toString();
        }
    }
}
