package com.xianzhou.kickballleague.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.xianzhou.kickballleague.models.Login;
import com.xianzhou.kickballleague.models.Registration;
import com.xianzhou.kickballleague.models.Team;
import com.xianzhou.kickballleague.repositories.RegRepository;

@Service
public class UserService {
	@Autowired
	private RegRepository regRepo;
	
	//registration part
	public Registration register (Registration newUser, BindingResult result) {
			
	//1. to test if email has been taken, return error msg
		Optional <Registration> potentialUser = regRepo.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "This email was taken.");
		}
		
	//2. next, to test if psw match the first time input
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
		result.rejectValue("password", "Matches", "Password does not match.");
	    }
		
	//3. next, don't return anything if model-level has error
		if (result.hasErrors()) {
			return null;
		}
		
	//4. if passed all above 3, hash psw and save to DB
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
				
		return regRepo.save(newUser); //save this user to DB
	}

	//Login part
	public Registration login(Login newLogin, BindingResult result) {
			
	//1. to test if email can be found in DB, if not, don't return anything
		Optional <Registration> potentialUser = regRepo.findByEmail(newLogin.getEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "This email does not exist.");
			return null;
		}
	//2. if user exist in DB, retrieve user info from DB. Reason that did not use "Login" type although it is a login test, is bc DB does not have "Login" model info, bc we don't store this model info to DB
		Registration user = potentialUser.get();
	
	//3. if psw does not match with what's in DB, reject user, return error msg
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Incorrect password.");
		}
		
	//4. don't return anything if model-level has error
		if (result.hasErrors()) {
			return null;
		}
	//if passed all above 4, return "Login" object directly
		return user;
      }
	
	////////////////////////////////////////////////////////////////////
	public Registration findByEmail (String email) {
		Optional<Registration> search = regRepo.findByEmail(email);
		if(search.isPresent()) {
			return search.get();
		}
		return null;
	}
	
	public Registration findById(Long id) {
		Optional<Registration> search = regRepo.findById(id);
		if(search.isPresent()) {
			return search.get();
		}
		return null;
	}
	
	public List<Registration> all(){   //fine all users
		return regRepo.findAll();
	}
}







