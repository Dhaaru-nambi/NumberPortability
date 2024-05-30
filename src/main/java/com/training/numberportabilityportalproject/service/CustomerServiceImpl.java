package com.training.numberportabilityportalproject.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.numberportabilityportalproject.entities.Customer;
import com.training.numberportabilityportalproject.entities.Status;
import com.training.numberportabilityportalproject.repositories.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repo;
	@Override
	public Customer addCustomer(Customer customer) {
		customer.setStatus(Status.PENDING);
		Customer cust= repo.save(customer);
		return cust;
	}

	@Override
	public Customer getCustomerById(Integer id) {
		Optional<Customer> cust=repo.findById(id);
		if(cust.isPresent())
		{
			return cust.get();
		}
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
	    Customer cust= repo.save(customer);
		return cust;
	}

	@Override
	public String deleteCustomerById(Integer id) {
		Optional<Customer> cust=repo.findById(id);
		if(cust.isPresent())
		{
			repo.deleteById(id);
			return "Deleted Successfully!!";
		}
		return null;
	}

}