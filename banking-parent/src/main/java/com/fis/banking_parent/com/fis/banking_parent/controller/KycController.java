package com.fis.banking_parent.com.fis.banking_parent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.banking_parent.com.fis.banking_parent.dto.KycRequestDto;
import com.fis.banking_parent.com.fis.banking_parent.dto.KycResponseDto;
import com.fis.banking_parent.com.fis.banking_parent.dto.RejectRequestDto;
import com.fis.banking_parent.com.fis.banking_parent.service.KycService;

@RestController
@RequestMapping("/api/kyc")
public class KycController {

    @Autowired
    private KycService kycService;

    // US-011 Submit KYC
    @PostMapping("/submit")
    public ResponseEntity<KycResponseDto> submitKyc(
            @RequestBody KycResponseDto dto) {
    	
        KycResponseDto response = kycService.submitKyc(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // US-013 Approve KYC
    @PutMapping("/approve/{id}")
    public ResponseEntity<KycResponseDto> approveKyc(
            @PathVariable Long id) {

        KycResponseDto response = kycService.approveKyc(id);
        return ResponseEntity.ok(response);
    }

    // US-014 Reject KYC
    @PutMapping("/reject/{id}")
    public ResponseEntity<KycResponseDto> rejectKyc(
            @PathVariable Long id,
            @RequestBody RejectRequestDto dto) {

        KycResponseDto response = kycService.rejectKyc(id, dto);
        return ResponseEntity.ok(response);
    }

    // US-015 View KYC Status
    @GetMapping("/status/{customerId}")
    public ResponseEntity<KycResponseDto> getKycStatus(
            @PathVariable Long customerId) {

        KycResponseDto response = kycService.getKycStatus(customerId);
        return ResponseEntity.ok(response);
    }
}