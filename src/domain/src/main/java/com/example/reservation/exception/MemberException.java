package com.example.reservation.exception;

import com.example.reservation.domain.dto.web.MemberForm;

public class MemberException extends RuntimeException{
    private final MemberForm memberForm;

    public MemberException(String message, MemberForm memberForm) {
        super(message);
        this.memberForm = memberForm;
    }

    public MemberForm getMemberForm() {
        return memberForm;
    }
}
