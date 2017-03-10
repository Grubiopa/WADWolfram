package com.mycompany.mavenproject1;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserPersonalData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String surname;
	private String email;
	private String userName;
	private String oldPassword;
	private String newPassword;
	private String photo;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	// protected UserMovements(){}

	public UserPersonalData(String name, String surname, String email, String userName, String oldPassword,
			String newPassword, String photo, List<String> roles) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.userName = userName;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.photo = photo;
		this.roles = roles;
	}

	public UserPersonalData() {
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

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}