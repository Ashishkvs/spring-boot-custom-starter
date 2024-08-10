package com.omsent.coreservice.service;

import com.omsent.coreservice.dto.JwtResponseDto;
import com.omsent.coreservice.dto.LoginDto;
import com.omsent.coreservice.dto.SignupDto;
import com.omsent.coreservice.entity.UserAccount;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final UserAccountService userAccountService;

    private final CustomUserDetailService customUserDetailService;

    private final JwtService jwtService;

    public SignupDto signupNewUser(SignupDto signupDto) {

        log.info("signupNewUser() -> request={}", signupDto);
        UserAccount userAccount = new UserAccount();

        userAccount.setName(signupDto.getName());
        userAccount.setUsername(signupDto.getUsername());
        userAccount.setPassword(passwordEncoder.encode(signupDto.getPassword()));

        userAccountService.saveUserAccount(userAccount);
        return signupDto;
    }

    public JwtResponseDto loginUser(LoginDto loginDto) {
        //validate user first
        Authentication authenticate = authenticate(loginDto);

        //load user details
        UserDetails userDetails = customUserDetailService.loadUserByUsername(loginDto.getUsername());

        //generate token using user details
        String jwtToken = jwtService.generateToken(userDetails);

        JwtResponseDto jwtResponseDto = new JwtResponseDto();

        jwtResponseDto.setToken(jwtToken);
        jwtResponseDto.setExpiresIn(jwtService.getExpirationTime());

        return jwtResponseDto;

    }

    public Authentication authenticate(LoginDto loginDto) {
        log.info("authenticate loginDto={}", loginDto);
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                )
        );


    }

}