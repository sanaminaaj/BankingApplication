package com.fis.banking_parent.com.fis.banking_parent.dto;

import com.fis.banking_parent.com.fis.banking_parent.enums.AccountStatus;

public class UpdateStatusDto {

    private AccountStatus status;

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

}