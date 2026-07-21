package com.fis.banking_parent.com.fis.banking_parent.dto;

import com.fis.banking_parent.com.fis.banking_parent.enums.AccountType;

public class AccountRequestDto {

    private Long customerId;

    private AccountType accountType;
    
    private double initialDeposit;

    public void setInitialDeposit(double initialDeposit) {
		this.initialDeposit = initialDeposit;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	private Double balance;

	public Double getInitialDeposit() {
		// TODO Auto-generated method stub
		return initialDeposit;
	}

}