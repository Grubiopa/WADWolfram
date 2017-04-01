package com.mycompany.mavenproject1.donation;

import java.util.Date;
import java.time.LocalDateTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class UserMovement {
private double money; 
private Date date;

public UserMovement(		double money){
	   this.money=money;
	   this.date=new Date();
}

public double getMoney(){
	   return money;
}

public void setMoney(double money){
	   this.money=money;
}

public Date getDate(){
	   return date;
}

public void setDate(Date date){
	   this.date=date;
}

}
