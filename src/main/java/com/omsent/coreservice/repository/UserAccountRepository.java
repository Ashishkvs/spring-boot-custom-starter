package com.omsent.coreservice.repository;

import com.omsent.coreservice.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

    Optional<UserAccount> findUserAccountById(Long id);

    Optional<UserAccount> findByUsername(String username);
}