package com.mycompany.mavenproject1;

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
	private long userId;
	private long projectId;
	private double money;
	private Date date;
	public Donation(){}
	public Donation(long userId, long projectId, double money, Date date) {
		super();
		this.userId = userId;
		this.projectId = projectId;
		this.money = money;
		this.date = date;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
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
