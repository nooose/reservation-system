package com.example.reservation.domain.dto.api;

import lombok.Data;

@Data
public class ResponseDto<T> {
    private int count;
    private T data;

    public ResponseDto(int count, T data) {
        this.count = count;
        this.data = data;
    }

    public ResponseDto(T data) {
        this.count = 1;
        this.data = data;
    }
}
