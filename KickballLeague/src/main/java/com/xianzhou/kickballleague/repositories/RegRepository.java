package com.xianzhou.kickballleague.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xianzhou.kickballleague.models.Registration;

@Repository
public interface RegRepository extends CrudRepository<Registration, Long>{
	List<Registration> findAll();
	Optional<Registration> findByEmail(String email);
	
}