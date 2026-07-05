package com.fis.banking_parent.com.fis.banking_parent.service;

import com.fis.banking_parent.com.fis.banking_parent.dto.KycResponseDto;
import com.fis.banking_parent.com.fis.banking_parent.dto.RejectRequestDto;

public interface KycService {

    KycResponseDto submitKyc(KycResponseDto dto);

    KycResponseDto approveKyc(Long id);

    KycResponseDto rejectKyc(Long id, RejectRequestDto dto);

    KycResponseDto getKycStatus(Long customerId);
}