package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;

public class User {

 @ManyToMany
	private List<Project> colaborateProjects;
 @ManyToMany
	private List<Project> otherProjects;
 @OneToMany(mappedBy="user")
	private List<Donation> donations;
 @OneToOne(cascade=CascadeType.ALL)
	UserPersonalData user;
 @ElementCollection(fetch = FetchType.EAGER)
 private List<String> roles;
	
 protected User(){}	

	public User(List<Project> colaborateProjects, List<Project> otherProjects,
			List<Donation> donations, UserPersonalData user, List<String> roles) {
		this.colaborateProjects = colaborateProjects;
		this.otherProjects = otherProjects;
		this.donations=donations;
		this.user = user;
  this.roles=roles;
	}

    public User(UserPersonalData user){
		this.colaborateProjects = new ArrayList<>();
		this.otherProjects = new ArrayList<>();
		this.donations = new ArrayList<>();
		this.user = user;
  this.roles = new ArrayList<>();
	}

	public List<Project> getColaborateProjects() {
		return colaborateProjects;
	}

	public void setColaborateProjects(List<Project> colaborateProjects) {
		this.colaborateProjects = colaborateProjects;
	}

 public void addColaborateProjects(Project p){
   colaborateProjects.add(p);
 }

	public List<Project> getOtherProjects() {
		return otherProjects;
	}

	public void setOtherProjects(List<Project> otherProjects) {
		this.otherProjects = otherProjects;
	}

 public void addOtherProject(Project p){
   otherProjects.add(p);
 }

	public List<Donation> getDonations(){
		return donations;
	}

	public void setDonation(List<Donation> donations){
		this.donations=donations;
	}

 public void addDonation(Donation d){
   donations.add(d);
 }

	public UserPersonalData getUser() {
		return user;
	}

	public void setUser(UserPersonalData user) {
		this.user = user;
	}	

    public List<String> getRoles(){ 
   return roles;
 }
 public void setRoles(List<String> roles){
   this.roles=roles;
 }
 public void addRole(String r){
   roles.add(r);
 }
}