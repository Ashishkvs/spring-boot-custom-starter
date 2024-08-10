package com.omsent.coreservice.service;


import com.omsent.coreservice.entity.UserAccount;
import com.omsent.coreservice.repository.UserAccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserAccountService {


    private final UserAccountRepository userAccountRepository;


    public UserAccount getUserAccountById(Long id) {
        log.info("getUserAccountById -> id={}", id);
        return userAccountRepository.findUserAccountById(id).orElseThrow(() -> new RuntimeException("Invalid userId"));
    }

    public UserAccount saveUserAccount(UserAccount userAccount) {
        log.info("saveUserAccount -> userAccount={}", userAccount);
        return userAccountRepository.save(userAccount);
    }


    public List<UserAccount> getAllUserAccount() {
        log.info("getAllUserAccount");
        return (List<UserAccount>) userAccountRepository.findAll();
    }
}