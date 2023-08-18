package com.xianzhou.kickballleague.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xianzhou.kickballleague.models.Team;
import com.xianzhou.kickballleague.repositories.TeamRepository;

@Service
public class TeamService {
	@Autowired
	private TeamRepository teamRepo;
	
	public Team findById(Long id) {  //find one team
		Optional <Team> search = teamRepo.findById(id);
		if (search.isPresent()) {
			return search.get();
		}
		return null;
	}
	
	public List<Team> all(){   //fine all team and list them down
		return teamRepo.findAll();
	}
	
	public Team create (Team team) {   //create a team
		return teamRepo.save(team);
	}
	
	public Team update (Team team) {   //update a team
		return teamRepo.save(team);
	}
	
	public void delete (Long id) { //delete a team
		teamRepo.deleteById(id);
	}
}
