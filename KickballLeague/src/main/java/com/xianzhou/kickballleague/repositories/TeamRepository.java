package com.xianzhou.kickballleague.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.xianzhou.kickballleague.models.Team;

public interface TeamRepository extends CrudRepository<Team, Long>{
	List <Team> findAll(); 

}
