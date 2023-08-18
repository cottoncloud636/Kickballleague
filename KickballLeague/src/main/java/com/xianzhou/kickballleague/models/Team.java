package com.xianzhou.kickballleague.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="team")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message="Team name can not be empty.")
	private String teamName;
	
	@NotNull (message="Must enter skill level.")
	private int skillLevel;
	
//	@NotBlank(message="Please enter players' number.")
//    private String playNum;
	
	@NotBlank(message="Game day can not be empty.")
    private String gameDay;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;

	
	@PrePersist
	protected void onCreated() {
		this.createdAt=new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="registration_id")
	private Registration registration;
	
	//constructor
	public Team() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

//	public String getPlayNum() {
//		return playNum;
//	}
//
//	public void setPlayNum(String playNum) {
//		this.playNum = playNum;
//	}

	public String getGameDay() {
		return gameDay;
	}

	public void setGameDay(String gameDay) {
		this.gameDay = gameDay;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
}



