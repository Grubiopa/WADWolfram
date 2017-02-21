package com.mycompany.mavenproject1;

import java.util.ArrayList;

public class User {
	
	ArrayList<UserProject> colaborateProjects;
	ArrayList<UserProject> otherProjects;
	ArrayList<UserMovements> userMovements;
	UserPersonalData user;
	
	public User(ArrayList<UserProject> colaborateProjects, ArrayList<UserProject> otherProjects,
			ArrayList<UserMovements> userMovements, UserPersonalData user) {
		super();
		this.colaborateProjects = colaborateProjects;
		this.otherProjects = otherProjects;
		this.userMovements = userMovements;
		this.user = user;
	}

	public ArrayList<UserProject> getColaborateProjects() {
		return colaborateProjects;
	}

	public void setColaborateProjects(ArrayList<UserProject> colaborateProjects) {
		this.colaborateProjects = colaborateProjects;
	}

	public ArrayList<UserProject> getOtherProjects() {
		return otherProjects;
	}

	public void setOtherProjects(ArrayList<UserProject> otherProjects) {
		this.otherProjects = otherProjects;
	}

	public ArrayList<UserMovements> getUserMovements() {
		return userMovements;
	}

	public void setUserMovements(ArrayList<UserMovements> userMovements) {
		this.userMovements = userMovements;
	}

	public UserPersonalData getUser() {
		return user;
	}

	public void setUser(UserPersonalData user) {
		this.user = user;
	}
	
	
	
	
}
