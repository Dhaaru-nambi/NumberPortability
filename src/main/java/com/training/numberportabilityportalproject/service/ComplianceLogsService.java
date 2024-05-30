package com.training.numberportabilityportalproject.service;


import com.training.numberportabilityportalproject.entities.ComplianceLog;

public interface ComplianceLogsService {
	
	public ComplianceLog addLog(ComplianceLog complianceLogs);
	
	public ComplianceLog getLog(Integer LogId);
	
	public ComplianceLog UpdateLog(ComplianceLog complianceLogs);
	
	

}