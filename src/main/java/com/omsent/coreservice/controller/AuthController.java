package com.omsent.coreservice.controller;

import com.omsent.coreservice.dto.JwtResponseDto;
import com.omsent.coreservice.dto.LoginDto;
import com.omsent.coreservice.dto.SignupDto;
import com.omsent.coreservice.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupNewUser(@RequestBody SignupDto signupDto) {

        return new ResponseEntity<>(authService.signupNewUser(signupDto), HttpStatus.CREATED);


    }

    @PostMapping("/login")
    public ResponseEntity<?> signupNewUser(@RequestBody LoginDto loginDto) {

        //validate user
        JwtResponseDto jwtResponseDto = authService.loginUser(loginDto);

        return new ResponseEntity<>(jwtResponseDto, HttpStatus.OK);

    }


}