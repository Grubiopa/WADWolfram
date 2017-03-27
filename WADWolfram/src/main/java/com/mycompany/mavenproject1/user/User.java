package com.mycompany.mavenproject1.user;

import java.util.List;

public class User {


	private List<UserProject> colaborateProjects;
	private List<UserProject> otherProjects;
	private List<UserMovements> donations;
	private UserPersonalData user;
	
 protected User(){}	

	public List<UserProject> getColaborateProjects() {
		return colaborateProjects;
	}

	public User(List<UserProject> colaborateProjects, List<UserProject> otherProjects, List<UserMovements> donations,
			UserPersonalData user) {
		super();
		this.colaborateProjects = colaborateProjects;
		this.otherProjects = otherProjects;
		this.donations = donations;
		this.user = user;
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

	public List<UserMovements> getDonations(){
		return donations;
	}

	public void setDonation(List<UserMovements> donations){
		this.donations=donations;
	}

	public UserPersonalData getUser() {
		return user;
	}

	public void setUser(UserPersonalData user) {
		this.user = user;
	}	

}