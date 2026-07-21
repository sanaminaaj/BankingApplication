package com.fis.banking_parent.com.fis.banking_parent.service;

import com.fis.banking_parent.com.fis.banking_parent.dto.RegisterRequest;
import com.fis.banking_parent.com.fis.banking_parent.dto.RegisterResponse;
import com.fis.banking_parent.com.fis.banking_parent.entity.Customer;
import com.fis.banking_parent.com.fis.banking_parent.entity.User;
import com.fis.banking_parent.com.fis.banking_parent.enums.AccountStatus;
import com.fis.banking_parent.com.fis.banking_parent.repository.CustomerRepository;
import com.fis.banking_parent.com.fis.banking_parent.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.stereotype.Service;

	
	@Service
	public class UserServiceImpl implements UserService {

	    private final UserRepository userRepository;
	    private final CustomerRepository customerRepository;
	    private final PasswordEncoder passwordEncoder;

	    public UserServiceImpl(UserRepository userRepository,
	                           CustomerRepository customerRepository,
	                           PasswordEncoder passwordEncoder) {

	        this.userRepository = userRepository;
	        this.customerRepository = customerRepository;
	        this.passwordEncoder = passwordEncoder;
	    }

	    @Override
	    public RegisterResponse register(RegisterRequest request) {

	        // 1. Find Customer
	    	Customer customer = customerRepository
	    	        .findById(request.getCustomerId())
	    	        .orElseThrow(() -> new RuntimeException("Customer Not Found"));
	        // 2. Check ACTIVE Account
	        if (!customer.getAccountStatus().equals(AccountStatus.ACTIVE)) {
	            throw new RuntimeException("Customer Account is not ACTIVE");
	        }

	        // 3. Username already exists?
	        if (userRepository.existsByUsername(request.getUsername())) {
	            throw new RuntimeException("Username already exists");
	        }

	        // 4. Create User
	        User user = new User();

	        user.setUsername(request.getUsername());

	        // Encrypt Password
	        user.setPassword(passwordEncoder.encode(request.getPassword()));

	        user.setRole("CUSTOMER");
	        user.setStatus("ACTIVE");
	        user.setCustomer(customer);

	        // 5. Save User
	        userRepository.save(user);

	        return new RegisterResponse("Registration Successful");

	    }

	}
	