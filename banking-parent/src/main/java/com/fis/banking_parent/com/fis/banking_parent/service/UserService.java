package com.fis.banking_parent.com.fis.banking_parent.service;

import com.fis.banking_parent.com.fis.banking_parent.dto.RegisterRequest;
import com.fis.banking_parent.com.fis.banking_parent.dto.RegisterResponse;

public interface UserService {

    RegisterResponse register(RegisterRequest request);

}