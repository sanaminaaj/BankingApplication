package com.fis.banking_parent.com.fis.banking_parent.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.banking_parent.com.fis.banking_parent.dto.AccountRequestDto;
import com.fis.banking_parent.com.fis.banking_parent.dto.AccountResponseDto;
import com.fis.banking_parent.com.fis.banking_parent.dto.UpdateStatusDto;
import com.fis.banking_parent.com.fis.banking_parent.entity.Account;
import com.fis.banking_parent.com.fis.banking_parent.entity.Customer;
import com.fis.banking_parent.com.fis.banking_parent.entity.KycStatus;
import com.fis.banking_parent.com.fis.banking_parent.enums.AccountStatus;
import com.fis.banking_parent.com.fis.banking_parent.repository.AccountRepository;
import com.fis.banking_parent.com.fis.banking_parent.repository.CustomerRepository;


@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public AccountResponseDto createAccount(AccountRequestDto dto) {
		// TODO Auto-generated method stub
		Customer customer=customerRepository.findById(dto.getCustomerId()).orElseThrow(()->new RuntimeException("Customer Not Found"));
		if(customer.getKycStatus()!=KycStatus.APPROVED) {
		      throw new RuntimeException("KYC not approved");

		}
		String accountNumber = generateAccountNumber();
		 // 4. Create account
		Account account = new Account();

		account.setAccountNumber(accountNumber);
		account.setAccountType(dto.getAccountType());
		account.setBalance(dto.getInitialDeposit());
		account.setStatus(AccountStatus.ACTIVE);
		account.setCustomer(customer);
		account.setCreatedAt(LocalDateTime.now());   // <-- REQUIRED

		Account savedAccount = accountRepository.save(account);

	    // 6. Prepare response
	    AccountResponseDto response = new AccountResponseDto();

	    response.setAccountId(savedAccount.getAccountId());
	    response.setAccountNumber(savedAccount.getAccountNumber());
	    response.setAccountType(savedAccount.getAccountType());
	    response.setBalance(savedAccount.getBalance());
	    response.setStatus(savedAccount.getStatus());
	    response.setCustomerId(customer.getCustomerId());
	    response.setCreatedAt(savedAccount.getCreatedAt());
	    
	    return response;
	}

	private String generateAccountNumber() {

	    Random random = new Random();

	    String accountNumber;

	    do {
	        accountNumber = String.valueOf(100000000000L + (long)(random.nextDouble() * 900000000000L));
	    } while (accountRepository.existsByAccountNumber(accountNumber));

	    return accountNumber;
	}
	@Override
	public AccountResponseDto getAccount(Long id) {

	    Account account = accountRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Account not found"));

	    AccountResponseDto response = new AccountResponseDto();

	    response.setAccountId(account.getAccountId());
	    response.setAccountNumber(account.getAccountNumber());
	    response.setAccountType(account.getAccountType());
	    response.setBalance(account.getBalance());
	    response.setStatus(account.getStatus());
	    response.setCustomerId(account.getCustomer().getCustomerId());

	    return response;
	}
	@Override
	public AccountResponseDto updateStatus(Long id, UpdateStatusDto dto) {

	    Account account = accountRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Account not found"));

	    account.setStatus(dto.getStatus());

	    Account updatedAccount = accountRepository.save(account);

	    AccountResponseDto response = new AccountResponseDto();

	    response.setAccountId(updatedAccount.getAccountId());
	    response.setAccountNumber(updatedAccount.getAccountNumber());
	    response.setAccountType(updatedAccount.getAccountType());
	    response.setBalance(updatedAccount.getBalance());
	    response.setStatus(updatedAccount.getStatus());
	    response.setCustomerId(updatedAccount.getCustomer().getCustomerId());

	    return response;
	}

}
