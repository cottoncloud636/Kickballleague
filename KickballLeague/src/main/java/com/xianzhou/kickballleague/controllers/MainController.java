package com.xianzhou.kickballleague.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.xianzhou.kickballleague.models.Login;
import com.xianzhou.kickballleague.models.Registration;
import com.xianzhou.kickballleague.models.Team;
import com.xianzhou.kickballleague.services.TeamService;
import com.xianzhou.kickballleague.services.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService userService;
	@Autowired
	private TeamService teamService;
	
	@GetMapping ("/") //user "get" the form info (to see what they need to fill out)
	public String index (Model model) {
		model.addAttribute("newUser", new Registration());
		model.addAttribute("newLogin", new Login());
		return "index.jsp";
	}
	
	@PostMapping ("/register") //user type in registration info (aka. "post" their info), click "submit" and go to "/register" url (usually hidden unless error msg occurred0
	public String register (@Valid @ModelAttribute("newUser") Registration newUser, BindingResult result, Model model, HttpSession session) {
		
		Registration user = userService.register(newUser, result); // Call a register method in the service to do some extra validations and create a new user.
	
		if(result.hasErrors()) { //if model-level has errors, be sure to send in empty LoginUser before re-rendering the page.
			model.addAttribute("newLogin",new Login());
			return "index.jsp";
		}
		
		session.setAttribute("userId", user.getId()); //here "userId" can be any name, "user" came from line39
		return "redirect:/home"; //if no errors, store new user's id from the DB in session, in other words, log them in.
		}
		
	@PostMapping ("/login") //old user type in their info into form and submit
	public String login (@Valid @ModelAttribute ("newLogin") Login newLogin, BindingResult result, Model model, HttpSession session) {
		Registration user = userService.login(newLogin, result); // Call a login method in the service to do some extra validations and get ready to log in old user.
		
		if (result.hasErrors()) {
			model.addAttribute("newUser",new Registration());
			return "index.jsp";
		}
		
		session.setAttribute("userId", user.getId()); //if no errors, store user's id from the DB in session, in other words, log them in.
		return "redirect:/home";
	}
	
	@GetMapping ("/home")
	public String home (HttpSession session, Model model) {
		if (session.getAttribute("userId") == null){ 
			return "redirect:/";
		}
		
		model.addAttribute("teams", teamService.all()); //"teams" can be any name
		model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));//"user" can be any name, "userId" came from line 48
		return "home.jsp"; //if user id is already in session, list all teams all info
	}
	
	@GetMapping ("/teams/new") //keep user log in and record who add the team, also to check if 
	public String addteam (@ModelAttribute("team") Team team, Model model, HttpSession session) {
		Registration user = userService.findById((Long)session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "addteam.jsp";
	}
	
	@PostMapping ("/teams")
	public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, Model model) {
		
		if (result.hasErrors()) { //if model-level has errors, rerender the addteam.jsp (which means the filling the current form failed)
			return "addteam.jsp";
		}
		
		teamService.create(team); //if no input errors, create a book
		return "redirect:/home";
	}
	
	@GetMapping("/teams/{id}") //to show the teams info
    public String showTeam(Model model, @PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("userId") == null) { //if user is not in session, redirect to index page
    		return "redirect:/";
    	}
    	
    	Team team = teamService.findById(id);
    	model.addAttribute("team", team);
    	model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
    	
    	List <Registration> allUsers = userService.all();
   
    	model.addAttribute("allUsers", allUsers);
    	return "team.jsp";
	}
    	
    @GetMapping("/teams/{id}/edit")
    public String editPage(@PathVariable("id") Long id, Model model, HttpSession session) {
        	
        if(session.getAttribute("userId") == null) {
        	return "redirect:/";
        	}
        	
        Team team = teamService.findById(id);
        model.addAttribute("team", team);
        	
        return "editPage.jsp";
        }

    @PutMapping("/teams/{id}") //update the team info
    public String updateTeam(@Valid @ModelAttribute("team") Team team, BindingResult result) {
    	
    	if (result.hasErrors()) {
    		return "editPage.jsp"; //stay on the edit page and keep editing
    	}

        teamService.update(team);    	
    	return "redirect:/home";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }

    @DeleteMapping("/teams/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		teamService.delete(id);
		return "redirect:/home";
	}
}
	