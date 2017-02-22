package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	List<UserProject> colaborateProjects;
	List<UserProject> otherProjects;
	List<UserMovements> userMovements;
	UserPersonalData user;
	
	

	public User(List<UserProject> colaborateProjects, List<UserProject> otherProjects,
			List<UserMovements> userMovements, UserPersonalData user) {
		super();
		this.colaborateProjects = colaborateProjects;
		this.otherProjects = otherProjects;
		this.userMovements = userMovements;
		this.user = user;
	}

	public List<UserProject> getColaborateProjects() {
		return colaborateProjects;
	}

	public void setColaborateProjects(List<UserProject> colaborateProjects) {
		this.colaborateProjects = colaborateProjects;
	}

	public List<UserProject> getOtherProjects() {
		return otherProjects;
	}

	public void setOtherProjects(List<UserProject> otherProjects) {
		this.otherProjects = otherProjects;
	}

	public List<UserMovements> getUserMovements() {
		return userMovements;
	}

	public void setUserMovements(List<UserMovements> userMovements) {
		this.userMovements = userMovements;
	}

	public UserPersonalData getUser() {
		return user;
	}

	public void setUser(UserPersonalData user) {
		this.user = user;
	}

	
	
	
	
}
