package com.crudoperation.jwt.repository;

import com.crudoperation.jwt.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccount,Integer> {
    Optional<UserAccount> findByUsername(String username);
}
