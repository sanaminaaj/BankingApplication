package com.fis.banking_parent.com.fis.banking_parent.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.banking_parent.com.fis.banking_parent.dto.AccountRequestDto;
import com.fis.banking_parent.com.fis.banking_parent.dto.AccountResponseDto;
import com.fis.banking_parent.com.fis.banking_parent.dto.UpdateStatusDto;
import com.fis.banking_parent.com.fis.banking_parent.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@PostMapping
	public ResponseEntity<AccountResponseDto> createAccount(@RequestBody AccountRequestDto dto) {

		return ResponseEntity.ok(accountService.createAccount(dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountResponseDto> getAccount(@PathVariable Long id) {

		return ResponseEntity.ok(accountService.getAccount(id));
	}

	@PutMapping("/{id}/status")
	public ResponseEntity<AccountResponseDto> updateStatus(@PathVariable Long id, @RequestBody UpdateStatusDto dto) {

		return ResponseEntity.ok(accountService.updateStatus(id, dto));
	}
}
