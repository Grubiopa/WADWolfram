package com.mycompany.mavenproject1;

public class UserPersonalData {
	String name;
	String surname;
	String email;
	String userName;
	String oldPassword;
	String newPassword;
	String photo;
	
	
	public UserPersonalData(String name, String surname, String email, String userName, String oldPassword,
			String newPassword, String photo) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.userName = userName;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.photo = photo;
	}
	public UserPersonalData(){			
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getOldPassword() {
		return oldPassword;
	}


	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}


	public String getNewPassword() {
		return newPassword;
	}


	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
