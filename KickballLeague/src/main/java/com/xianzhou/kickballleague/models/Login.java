package com.xianzhou.kickballleague.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Login {
	@NotEmpty (message="Must enter an email")
	@Email (message="Please enter a valid email")
	private String email;
	
	@NotEmpty
	@Size(min=8, max=200, message="Password length must be min 8 and max 200 characters")
	private String password;
	
	//constructor
	public Login() {
	}

	//getters and setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}