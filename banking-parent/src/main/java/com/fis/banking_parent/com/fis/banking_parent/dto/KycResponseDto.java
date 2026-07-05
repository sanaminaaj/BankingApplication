package com.fis.banking_parent.com.fis.banking_parent.dto;

import com.fis.banking_parent.com.fis.banking_parent.entity.DocumentType;
import com.fis.banking_parent.com.fis.banking_parent.entity.KycStatus;

public class KycResponseDto {
	private String documentNumber;
	private String documentUrl;
    public Long getKycId() {
		return kycId;
	}

	public void setKycId(Long kycId) {
		this.kycId = kycId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public KycStatus getStatus() {
		return status;
	}

	public void setStatus(KycStatus status) {
		this.status = status;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}
	public String getDocumentNumber() {
	    return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
	    this.documentNumber = documentNumber;
	}

	public String getDocumentUrl() {
	    return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
	    this.documentUrl = documentUrl;
	}
	private Long kycId;

    private Long customerId;

    private DocumentType documentType;

    private KycStatus status;

    private String rejectionReason;

    // getters setters
}