package com.koscom.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@Getter
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
