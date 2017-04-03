package com.mycompany.mavenproject1.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserPersonalData {

	interface Basico {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
@JsonView(Basico.class)
	private String name;
	private String lastname;
	private String email;
	private String userName;
	//@JsonIgnore
	private String passwordHash;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	
   public UserPersonalData(String name, String surname, String email, String userName, String oldPassword,
			String newPassword, String photo2, String...roles) {
		this.name = name;
		this.lastname = surname;
		this.email = email;
		this.userName = userName;
		this.passwordHash = new BCryptPasswordEncoder().encode(newPassword);
		this.roles = new ArrayList<>(Arrays.asList(roles));
	}
   
 	public boolean matchPassword(String pass){
   		return new BCryptPasswordEncoder().matches(pass, passwordHash);
   	}
 	
	public UserPersonalData() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPasswordHash() {
		// TODO Auto-generated method stub
		return passwordHash;
	}
	
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = new BCryptPasswordEncoder().encode(passwordHash);;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(String... roles) {
		this.roles =  new ArrayList<>(Arrays.asList(roles));
	}


}