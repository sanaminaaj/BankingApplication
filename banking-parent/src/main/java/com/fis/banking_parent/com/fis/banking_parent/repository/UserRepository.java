package com.fis.banking_parent.com.fis.banking_parent.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.banking_parent.com.fis.banking_parent.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

}