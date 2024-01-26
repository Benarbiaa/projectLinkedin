package com.fsb.linkedinProject.Models;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Employee extends User{
	private String lastName;
	private List<Experience> experiences ;
	private List<Competence> competences;
	private String gender;
	private String video;
	private Company company;
	
	
	
	public Employee(int idUser, String name, LocalDate birthday, String role, int phoneNumber, String addressPhysique,
			FileInputStream photo, String state, String lastName, List<Experience> experiences, List<Competence> competences,
			String gender, String video, Company company) {
		super(idUser, name, birthday, role, phoneNumber, addressPhysique, photo, state);
		this.lastName = lastName;
		this.experiences = experiences;
		this.competences = competences;
		this.gender = gender;
		this.video = video;
		this.company = company;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Experience> getExperiences() {
		return experiences;
	}
	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}
	public List<Competence> getCompetences() {
		return competences;
	}
	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	
	
	
}
