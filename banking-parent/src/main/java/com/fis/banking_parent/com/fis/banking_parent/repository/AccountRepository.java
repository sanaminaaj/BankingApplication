package com.fis.banking_parent.com.fis.banking_parent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.banking_parent.com.fis.banking_parent.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{

    boolean existsByAccountNumber(String accountNumber);

}
