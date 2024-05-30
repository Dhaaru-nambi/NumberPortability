package com.training.numberportabilityportalproject.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.numberportabilityportalproject.entities.PortRequest;
@Repository
public interface PortRequestRepository extends CrudRepository<PortRequest, Integer> {

}