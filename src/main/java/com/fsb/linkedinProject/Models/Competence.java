package com.fsb.linkedinProject.Models;

public class Competence {
	private int idCompetence;
	private String title;
	private String technology;
	private String description;
	private String level;
	public Competence(int idCompetence, String title, String technology, String description, String level) {
		super();
		this.idCompetence = idCompetence;
		this.title = title;
		this.technology = technology;
		this.description = description;
		this.level = level;
	}
	public int getIdCompetence() {
		return idCompetence;
	}
	public void setIdCompetence(int idCompetence) {
		this.idCompetence = idCompetence;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
}
