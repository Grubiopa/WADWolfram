package com.mycompany.mavenproject1;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Donation {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
 @ManyToOne(mappedBy="donations")
	private User user;
 @ManyToOne(mappedBy="donations")
	private Project project;
	private double money;
	private Calendar date;

 protected Donation(){}

	public Donation(User user, Project project, double money, Calendar date) {
		this.user = user;
		this.project = project;
		this.money = money;
		this.date = date;
	}
  public User getUser() {
		return user;
	}
	public void setUser(User user){
		this.user = user;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	
}
