package com.example.reservation.controller.web;

import com.example.reservation.domain.dto.web.MemberForm;
import com.example.reservation.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String join(@ModelAttribute("memberForm") MemberForm memberForm) {
        return "members/addMemberForm";
    }

    @PostMapping("/join")
    public String save(@Valid @ModelAttribute("memberForm") MemberForm memberForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "members/addMemberForm";
        }
        memberService.join(memberForm);

        return "redirect:/";
    }
}
