package com.fis.banking_parent.com.fis.banking_parent.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.banking_parent.com.fis.banking_parent.entity.Kyc;

@Repository
public interface KycRepository extends JpaRepository<Kyc, Long> {

    Optional<Kyc> findByCustomerId(Long customerId);

    boolean existsByCustomerId(Long customerId);
}