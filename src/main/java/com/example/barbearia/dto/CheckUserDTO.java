package com.example.barbearia.dto;

import lombok.Data;

@Data
public class CheckUserDTO {
    private String email;
    private String token;

    public CheckUserDTO(String email, String token) {
        this.email = email;
        this.token = token;
    }
}
