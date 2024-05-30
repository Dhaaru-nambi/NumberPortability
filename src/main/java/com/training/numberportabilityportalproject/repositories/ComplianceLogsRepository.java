package com.training.numberportabilityportalproject.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.numberportabilityportalproject.entities.ComplianceLog;

@Repository
public interface ComplianceLogsRepository extends CrudRepository<ComplianceLog, Integer> {

}