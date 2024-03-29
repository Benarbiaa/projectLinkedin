package com.fsb.linkedinProject.Models;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;

public abstract class User {
	protected int idUser;
	protected String name;
	protected LocalDate birthday;
	protected String role;
	protected int phoneNumber;
	protected String addressPhysique;
	protected FileInputStream photo;
	protected String state;
	
	
	
	
	
	public User(int idUser, String name, LocalDate birthday, String role, int phoneNumber, String addressPhysique,
			FileInputStream photo, String state) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.birthday = birthday;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.addressPhysique = addressPhysique;
		this.photo = photo;
		this.state = state;
	}
	
	
	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getBirthday() {
		return birthday;
	}


	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAddressPhysique() {
		return addressPhysique;
	}


	public void setAddressPhysique(String addressPhysique) {
		this.addressPhysique = addressPhysique;
	}


	public FileInputStream getPhoto() {
		return photo;
	}


	public void setPhoto(FileInputStream photo) {
		this.photo = photo;
	}


	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", birthday=" + birthday + ", role=" + role + "]";
	}
	
	
}
