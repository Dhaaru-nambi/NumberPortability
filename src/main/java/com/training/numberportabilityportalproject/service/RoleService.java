package com.training.numberportabilityportalproject.service;


import java.util.Optional;

import com.training.numberportabilityportalproject.entities.ERole;
import com.training.numberportabilityportalproject.entities.Role;

public interface RoleService {
	
	public Optional<Role> findRoleByName(ERole role);
	
	public Optional<Role> findRoleById(Integer id);

}
