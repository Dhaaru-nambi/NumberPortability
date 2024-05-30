package com.training.numberportabilityportalproject.service;

import com.training.numberportabilityportalproject.entities.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);

	public Customer getCustomerById(Integer id);

	public Customer updateCustomer(Customer customer);
	
	public String deleteCustomerById(Integer id);
	
	

}