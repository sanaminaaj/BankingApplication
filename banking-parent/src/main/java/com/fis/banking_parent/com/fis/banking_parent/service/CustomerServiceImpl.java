package com.fis.banking_parent.com.fis.banking_parent.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fis.banking_parent.com.fis.banking_parent.entity.Customer;
import com.fis.banking_parent.com.fis.banking_parent.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository cRepo;
	CustomerServiceImpl(CustomerRepository cRepo){
		this.cRepo=cRepo;
	}
	@Override
	public Customer registerCustomer(Customer c) {

	    System.out.println("Incoming Email: " + c.getEmail());

	    boolean emailExists = cRepo.existsByEmail(c.getEmail());
	    System.out.println("Email Exists: " + emailExists);

	    boolean mobileExists = cRepo.existsByMobileNumber(c.getMobileNumber());
	    System.out.println("Mobile Exists: " + mobileExists);

	    if (emailExists) {
	        throw new RuntimeException("Email already exists");
	    }

	    if (mobileExists) {
	        throw new RuntimeException("Mobile already exists");
	    }

	    return cRepo.save(c);
	}
	@Override
	public Customer getCustomer(Long id) {
		// TODO Auto-generated method stub
		return cRepo.findById(id).orElseThrow(()->new RuntimeException("Customer not found"));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		cRepo.deleteById(id);
	}

	@Override
	public Customer update(Long id, Customer c) {
		// TODO Auto-generated method stub
		Customer existing=cRepo.findById(id).orElseThrow(()->new RuntimeException("Customer not found"));
		existing.setCustomerName(c.getCustomerName());
		existing.setCity(c.getCity());
		existing.setEmail(c.getEmail());
		existing.setMobileNumber(c.getMobileNumber());
		return cRepo.save(existing);
	}

}
