package com.mycompany.mavenproject1;

public class UserProject {
	String title;
	String shortDescription;
	Double money;
	
	public UserProject(String title, String shortDescription, Double money) {
		super();
		this.title = title;
		this.shortDescription = shortDescription;
		this.money = money;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
	
	
}