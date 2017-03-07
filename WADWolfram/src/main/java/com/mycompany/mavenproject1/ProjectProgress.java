package com.mycompany.mavenproject1;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private int percentage;

    protected ProjectProgress(){} 
  
    public ProjectProgress(String title, double percentage){
      this.title=title;
      this.percentage=percentage;
    }

    public String getTitle(){
      return title;
    }

    public void setTitle(String title){
      this.title=title;
    }
 
    public int getPercentage(){
      return percentage;
    }

    public void setPercentage(int percentage){
      this.percentage=percentage;
    }
}