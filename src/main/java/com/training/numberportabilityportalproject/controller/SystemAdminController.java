package com.training.numberportabilityportalproject.controller;

 import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.numberportabilityportalproject.entities.ERole;
import com.training.numberportabilityportalproject.entities.Operator;
import com.training.numberportabilityportalproject.entities.Role;
import com.training.numberportabilityportalproject.entities.request.OperatorRequest;
import com.training.numberportabilityportalproject.service.OperatorService;
import com.training.numberportabilityportalproject.service.RoleService;
import com.training.numberportabilityportalproject.service.UserEntityService;

@RestController
@RequestMapping("/api/admin")
public class SystemAdminController {

	@Autowired
	UserEntityService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	OperatorService operatorService;

	@PostMapping("/updateuserrole")
	public ResponseEntity<String> updateUserRole(@RequestParam("id") Integer userId, @RequestParam("role") ERole role) {
		Optional<Role> r = roleService.findRoleByName(role);
		String message = userService.updateRole(userId, r.get());
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@PostMapping("/addoperator")
	public ResponseEntity<Operator> addOperator(@RequestBody OperatorRequest operatorRequest) {
		Operator operator = new Operator();
		operator.setOperatorName(operatorRequest.getOperatorName());
		operator.setContactInfo(operatorRequest.getContactInfo());
		Operator op = operatorService.addOperator(operator);
		return new ResponseEntity<Operator>(op, HttpStatus.OK);
	}

	@PostMapping("/getoperator")
	public ResponseEntity<Operator> getOperator(@RequestParam("operatorId") Integer operatorId) {
		Operator operator = operatorService.getOperatorById(operatorId);
		return new ResponseEntity<Operator>(operator, HttpStatus.OK);
	}
	
	@PostMapping("/updateoperator")
	public ResponseEntity<Operator> updateOperator(@RequestBody Operator operator) {
		Operator op = operatorService.updateOperator(operator);
		return new ResponseEntity<Operator>(op, HttpStatus.OK);
	}
	
	@PostMapping("/deleteoperator")
	public ResponseEntity<String> deleteOperator(@RequestParam("operatorId") Integer operatorId) {
		String message = operatorService.deleteOperator(operatorId);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}


}
