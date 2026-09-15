package com.fis.banking_parent.com.fis.banking_parent.service;

import java.util.List;

import org.springframework.data.domain.Page;
import com.fis.banking_parent.com.fis.banking_parent.entity.Customer;

public interface CustomerService {
	public Customer registerCustomer(Customer c);
	
	public Customer getCustomer(Long id);
	
	public void delete(Long id);
	
	public Customer update(Long id,Customer c);
	
	public Page<Customer> getCustomers(int page,int size);
}
