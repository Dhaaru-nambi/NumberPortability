package com.training.numberportabilityportalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.numberportabilityportalproject.entities.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}