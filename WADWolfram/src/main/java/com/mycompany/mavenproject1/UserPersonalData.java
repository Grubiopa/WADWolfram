package com.mycompany.mavenproject1;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class UserPersonalData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String lastname;
	private String surname;
	private String email;
	private String userName;
	private String oldPassword;
	private String newPassword;
//	private MultipartFile photo;
	private String photo2;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	// protected UserMovements(){}
	
   public UserPersonalData(String name, String surname, String email, String userName, String oldPassword,
			String newPassword, String photo2, List<String> roles) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.userName = userName;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.photo2 = photo2;
		this.roles = roles;
	}

/*	public UserPersonalData(String name, String surname, String email, String userName, String oldPassword,
			String newPassword, MultipartFile photo, List<String> roles) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.userName = userName;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.photo = photo;
		this.roles = roles;
	}
	*/
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
	
	
	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	/*public MultipartFile getPhoto() {
		return photo;
	}

	public MultipartFile setPhoto(MultipartFile photo) {
		this.photo = photo;
		return photo;
	}
*/
	

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

}