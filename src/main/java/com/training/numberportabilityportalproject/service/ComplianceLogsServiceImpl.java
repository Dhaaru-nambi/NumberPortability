package com.training.numberportabilityportalproject.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.numberportabilityportalproject.repositories.ComplianceLogsRepository;
import com.training.numberportabilityportalproject.entities.ComplianceLog;

@Service
public class ComplianceLogsServiceImpl implements ComplianceLogsService {

	@Autowired
	ComplianceLogsRepository repo; 
	
	@Override
	public ComplianceLog addLog(ComplianceLog complianceLogs) {
		ComplianceLog complianceLog=repo.save(complianceLogs);
		return complianceLog;
	}

	@Override
	public ComplianceLog getLog(Integer LogId) {
		Optional<ComplianceLog> complianceLog=repo.findById(LogId);
		if(complianceLog.isPresent()) return complianceLog.get();
		return null;
	}

	@Override
	public ComplianceLog UpdateLog(ComplianceLog complianceLogs) {
		Optional<ComplianceLog> complianceLog=repo.findById(complianceLogs.getLogId());
		if(complianceLog.isPresent()) 
			{
			 repo.save(complianceLog.get());
			 return complianceLog.get();
			}
		return null;
	}

}