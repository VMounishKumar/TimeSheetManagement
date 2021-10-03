package com.model;

import javax.persistence.*;
@Entity
@Table(name="teammember")
public class TeamMember {
	@ManyToOne(targetEntity = Team.class)
	Team team ;
	@Id
	private int teamMemberId;
	
	
	@OneToOne
	private Roles role;
	
	
	public TeamMember() {
		super();
	}
	public TeamMember(int teamMemberId) {
		super();
		this.teamMemberId = teamMemberId;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public int getTeamMemberId() {
		return teamMemberId;
	}
	public void setTeamMemberId(int teamMemberId) {
		this.teamMemberId = teamMemberId;
	}
	
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "TeamMember [team=" + team + ", teamMemberId=" + teamMemberId + ", role=" + role + "]";
	}
	
	
	
	
	

}
