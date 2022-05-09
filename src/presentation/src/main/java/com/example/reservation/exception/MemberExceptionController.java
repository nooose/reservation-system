package com.example.reservation.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class MemberExceptionController {

    @ExceptionHandler(MemberException.class)
    public String memberException(MemberException exception, Model model) {
        model.addAttribute("memberForm", exception.getMemberForm());
        model.addAttribute("exception", exception.getMessage());

        return "members/addMemberForm";
    }
}
