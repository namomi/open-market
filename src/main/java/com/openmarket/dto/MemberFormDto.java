package com.openmarket.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberFormDto {
    private final String name;
    private final String email;
    private final String password;
    private final String address;
}
