package com.training.numberportabilityportalproject.service;


import com.training.numberportabilityportalproject.entities.PortRequest;

public interface PortRequestService {
	
	public PortRequest addPortRequest(PortRequest portRequest);
	
	public PortRequest getPortRequest(Integer portRequestId);
	
	public PortRequest updatePortRequest(PortRequest portRequest);

	public String deletePortRequest(Integer portRequestId);
}