package com.mycompany.mavenproject1;

public class Project {
	long id;
	String title;
	String shortDescription;
	String description;
	Double totalBudget;
	Double parcialBudget;
	Double restBudget;
	String type;
	String startYear;
	String image;
	
	
	
	public Project(long id, String title, String shortDescription, String description, Double totalBudget, Double parcialBudget,
			String type, String startYear,String image) {
		super();
		this.id=id;
		this.title = title;
		this.shortDescription = shortDescription;
		this.description = description;
		this.totalBudget = totalBudget;
		this.parcialBudget = parcialBudget;
		this.restBudget = totalBudget - parcialBudget;
		this.type = type;
		this.startYear = startYear;
		this.image = image;
	}
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getTotalBudget() {
		return totalBudget;
	}
	public void setTotalBudget(Double totalBudget) {
		this.totalBudget = totalBudget;
	}
	public Double getParcialBudget() {
		return parcialBudget;
	}
	public void setParcialBudget(Double parcialBudget) {
		this.parcialBudget = parcialBudget;
	}
	public Double getRestBudget() {
		return restBudget;
	}
	public void setRestBudget(Double restBudget) {
		this.restBudget = restBudget;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	
}
