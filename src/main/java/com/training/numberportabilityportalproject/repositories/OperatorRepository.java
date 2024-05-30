package com.training.numberportabilityportalproject.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.numberportabilityportalproject.entities.Operator;

@Repository
public interface OperatorRepository  extends CrudRepository<Operator, Integer>{

}
