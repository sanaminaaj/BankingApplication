package com.fis.banking_parent.com.fis.banking_parent.service;

import org.springframework.stereotype.Service;

import com.fis.banking_parent.com.fis.banking_parent.dto.KycRequestDto;
import com.fis.banking_parent.com.fis.banking_parent.dto.KycResponseDto;
import com.fis.banking_parent.com.fis.banking_parent.dto.RejectRequestDto;
import com.fis.banking_parent.com.fis.banking_parent.entity.Kyc;
import com.fis.banking_parent.com.fis.banking_parent.entity.KycStatus;
import com.fis.banking_parent.com.fis.banking_parent.repository.KycRepository;

@Service
public class KycServiceImpl implements KycService {
	private final KycRepository kycRepository;

	public KycServiceImpl(KycRepository kycRepository) {
		this.kycRepository = kycRepository;
	}

	@Override
	public KycResponseDto submitKyc(KycResponseDto dto) {
		// TODO Auto-generated method stub
		
		

		    Kyc kyc = new Kyc();

		    kyc.setCustomerId(dto.getCustomerId());
		    kyc.setDocumentType(dto.getDocumentType());
		    kyc.setDocumentNumber(dto.getDocumentNumber());
		    kyc.setStatus(KycStatus.PENDING);
		    kyc.setDocumentUrl(dto.getDocumentUrl());
		    if(kycRepository.existsByCustomerId(dto.getCustomerId())) {
		    	throw new RuntimeException("Customer ID exists");
		    }
		    Kyc saved = kycRepository.save(kyc);

		    return mapToResponse(saved);
		
	}

	private KycResponseDto mapToResponse(Kyc kyc) {

	    KycResponseDto dto = new KycResponseDto();

	    dto.setKycId(kyc.getKycId());
	    dto.setCustomerId(kyc.getCustomerId());
	    dto.setDocumentType(kyc.getDocumentType());
	    dto.setDocumentNumber(kyc.getDocumentNumber());
	    dto.setStatus(kyc.getStatus());
	    dto.setDocumentUrl(kyc.getDocumentUrl());
	    return dto;
	}
	@Override
	
	public KycResponseDto approveKyc(Long id) {

	    Kyc kyc = kycRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("KYC not found"));

	    kyc.setStatus(KycStatus.APPROVED);

	    Kyc saved = kycRepository.save(kyc);

	    return mapToResponse(saved);
	}

	@Override
	public KycResponseDto rejectKyc(Long id, RejectRequestDto dto) {

	    Kyc kyc = kycRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("KYC not found"));

	    kyc.setStatus(KycStatus.REJECTED);
	    kyc.setRejectionReason(dto.getRejectionReason());

	    Kyc saved = kycRepository.save(kyc);

	    return mapToResponse(saved);
	}

	@Override
	public KycResponseDto getKycStatus(Long customerId) {

	    Kyc kyc = kycRepository.findByCustomerId(customerId)
	            .orElseThrow(() -> new RuntimeException("KYC not found"));

	    return mapToResponse(kyc);
	}

}
