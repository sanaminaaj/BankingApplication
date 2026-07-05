package com.fis.banking_parent.com.fis.banking_parent.dto;

import com.fis.banking_parent.com.fis.banking_parent.entity.DocumentType;

public class KycRequestDto {

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

	private Long customerId;

    private DocumentType documentType;

    private String documentNumber;

    private String documentUrl;
    

    // getters setters
}