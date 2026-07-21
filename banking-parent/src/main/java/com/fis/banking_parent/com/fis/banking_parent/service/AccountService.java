package com.fis.banking_parent.com.fis.banking_parent.service;

import com.fis.banking_parent.com.fis.banking_parent.dto.AccountRequestDto;
import com.fis.banking_parent.com.fis.banking_parent.dto.AccountResponseDto;
import com.fis.banking_parent.com.fis.banking_parent.dto.UpdateStatusDto;

public interface AccountService {

    AccountResponseDto createAccount(AccountRequestDto dto);

    AccountResponseDto getAccount(Long id);

    AccountResponseDto updateStatus(Long id,
                    UpdateStatusDto dto);

}