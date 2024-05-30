package com.training.numberportabilityportalproject.service;


import java.util.Optional;

import com.training.numberportabilityportalproject.entities.ERole;
import com.training.numberportabilityportalproject.entities.Role;
import com.training.numberportabilityportalproject.entities.UserEntity;

public interface UserEntityService {

	public UserEntity addUserEntity(UserEntity user);

	public String updateRole(Integer userId, Role role);

	public Optional<UserEntity> findByUsername(String username);

	public Boolean existsByUsername(String username);

	public Optional<UserEntity> findByRole(ERole role);
}