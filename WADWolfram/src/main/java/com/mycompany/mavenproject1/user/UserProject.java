package com.mycompany.mavenproject1.user;

public class UserProject {
	private long projectId;
	private String title;
	private String shortDescription;
	private Double money;
	
	public UserProject(long id,String title, String shortDescription, Double money) {
		super();
		this.setProjectId(id);
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

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	
}
