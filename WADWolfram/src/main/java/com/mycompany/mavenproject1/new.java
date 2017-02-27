package com.mycompany.mavenproject1;

import java.util.List;
import java.util.Date;
import javax.persistence.Entity;

@entity
public class New{
@id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String title;
private String image;
private String body;
private Category category;
private int number_comments;
private List<String> comments;
private Date date;

//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//Date d = sdf.parse("21/12/2012");

protected New(){}

public New(String title, String image, String body){
this.title=title;
this.image=image;
this.body=body;
this.number_comments=0;
this.commentss=new ArrayList<>();
this.date = new Date();
}

public int getId(){
return this.id;
}

public String getTitle(){
return this.title;
}

public String getImage(){
return this.image;
}

public String getBody(){
return this.body;
}

public Category getCategory(){
return this.category;
}

public Date getDate(){
return this.date;
}

public int getNumberComments(){
return this.number_comments;
}

public List<String> getComments(){
return thsi.comments;
}

public void setId(int id){
this.id=id;
}

public void setTitle(String title){
this.title=title;
}

public void setImage(String image){
this.image=image;
}

public void setBody(String body){
this.body=body;
}

public void setCategory(Category category){
this.category=category;
}

public void addComment(String comment){
comments.add(comment);
number_comments++;
}

public void setDate(Date date){
this.date=date;
}
}