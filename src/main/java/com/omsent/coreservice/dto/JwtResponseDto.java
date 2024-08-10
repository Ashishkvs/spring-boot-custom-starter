package com.omsent.coreservice.dto;

import lombok.Data;

@Data
public class JwtResponseDto {

    private String token;
    private Long expiresIn;
}