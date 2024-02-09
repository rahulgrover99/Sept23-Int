package com.example.bookmyshow.dtos;

import lombok.Data;

@Data
public class RegisterUserRequestDto {
    private String name;
    private String email;
    private String password;
}
