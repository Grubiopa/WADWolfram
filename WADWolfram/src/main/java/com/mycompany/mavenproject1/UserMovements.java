package com.mycompany.mavenproject1;

import java.util.Date;

public class UserMovements {
	String projectTitle;
	Double money;
	Date date;
	
	public UserMovements(String projectTitle, Double money, Date date) {
		super();
		this.projectTitle = projectTitle;
		this.money = money;
		this.date = date;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
