package com.omsent.coreservice.controller;

import com.omsent.coreservice.entity.UserAccount;
import com.omsent.coreservice.service.UserAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;

    @PostMapping
    public ResponseEntity<?> saveUserAccount(@RequestBody UserAccount userAccount) {
        UserAccount savedUserAccount = userAccountService.saveUserAccount(userAccount);

        return new ResponseEntity<>(savedUserAccount, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<?> getAllUserAccount() {
        List<UserAccount> allUserAccount = userAccountService.getAllUserAccount();

        return new ResponseEntity<>(allUserAccount, HttpStatus.CREATED);

    }
}