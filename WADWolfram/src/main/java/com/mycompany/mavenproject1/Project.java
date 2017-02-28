package com.mycompany.mavenproject1;

@entity
public class Project {
<<<<<<< HEAD
  @id
  @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String shortDescription;
	private String description;
	private double totalBudget;
	private double parcialBudget;
	private double restBudget;
 private double time;  
	private boolean opened;
 private Date releaseDate;
	private int startYear;
	private String image;
=======
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
>>>>>>> 075791d19c4fc432a276b98bd99ed80b4d46e1e3
	
  protected Project(){}	
	
<<<<<<< HEAD
	public Project(String title, String shortDescription, String description, double totalBudget, double parcialBudget,			double time, boolean opened, Date releaseDate, int startYear, String image) {
=======
	
	public Project(long id, String title, String shortDescription, String description, Double totalBudget, Double parcialBudget,
			String type, String startYear,String image) {
>>>>>>> 075791d19c4fc432a276b98bd99ed80b4d46e1e3
		super();
		this.id=id;
		this.title = title;
		this.shortDescription = shortDescription;
		this.description = description;
		this.totalBudget = totalBudget;
		this.parcialBudget = parcialBudget;
		this.restBudget = totalBudget - parcialBudget;
		this.time = time;
  this.opened=opened;
  this.releaseDate=releaseDate;
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
	public double getTotalBudget() {
		return totalBudget;
	}

	private void setRestBudget(double restBudget) {
		this.restBudget = restBudget;
	}

	public void setTotalBudget(double totalBudget) {
		this.totalBudget = totalBudget;
  this.setRestBudget(this.totalBuget-this.parcialBuget);
	}
	public double getParcialBudget() {
		return parcialBudget;
	}
	public void setParcialBudget(double parcialBudget) {
		this.parcialBudget = parcialBudget;
  this.setRestBudget(this.totalBuget-this.parcialBuget);
	}
	public double getRestBudget() {
		return restBudget;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
  public boolean getOpened(){
    return opened;
  }
  public void setOpened(boolean opened){
    this.opened=opened;
  }
  public Date getReleaseDate(){
    return releaseDate;
  }
  public void setReleaseDate(Date releaseDate){
   this.releaseDate=releaseDate;
  }
	public int getStartYear() {
		return startYear;
	}
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
	
}
