package com.training.numberportabilityportalproject.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.numberportabilityportalproject.entities.ERole;
import com.training.numberportabilityportalproject.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
	
	public Optional<UserEntity> findByUsername(String username);

	public Boolean existsByUsername(String username);
	
	public Optional<UserEntity> findByRole(ERole role);
}
