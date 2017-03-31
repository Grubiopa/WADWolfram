package com.mycompany.mavenproject1.donation;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.mavenproject1.project.Project;
import com.mycompany.mavenproject1.user.UserPersonalData;

@Entity
public class Donation {

	public interface Basico {

	}
	@Id
 @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
 @ManyToOne
	private UserPersonalData user;
 @ManyToOne
	private Project project;
@JsonView(Basico.class)
 private double money;
@JsonView(Basico.class)
@JsonFormat(pattern="dd-MM-yyyy")
	private Date date;

 protected Donation(){}

	public Donation(UserPersonalData user, Project project, double money, Date date) {
		this.user = user;
		this.project = project;
		this.money = money;
		this.date = date;
	}
  public UserPersonalData getUser() {
		return user;
	}
	public void setUser(UserPersonalData user){
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
