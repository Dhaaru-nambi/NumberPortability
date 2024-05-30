package com.training.numberportabilityportalproject.service;


import com.training.numberportabilityportalproject.entities.Operator;


public interface OperatorService {
	
	public Operator addOperator(Operator operator);
	
	public Operator getOperatorById(Integer id);
	
	public Operator updateOperator(Operator operator);
	
	public String deleteOperator(Integer id);
	
	

}