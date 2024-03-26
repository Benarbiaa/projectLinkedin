package project.linkedIn.models;

public class Experience {
	private int idExperience;
	private int periode;
	private String description;
	private String poste;
	private String technology;
	
	public Experience(int idExperience, int periode, String description, String poste, String technology) {
		super();
		this.idExperience = idExperience;
		this.periode = periode;
		this.description = description;
		this.poste = poste;
		this.technology = technology;
	}
	public Experience(int periode, String description, String poste, String technology) {
		super();
		this.periode = periode;
		this.description = description;
		this.poste = poste;
		this.technology = technology;
	}

	public int getIdExperience() {
		return idExperience;
	}

	public void setIdExperience(int idExperience) {
		this.idExperience = idExperience;
	}

	public int getPeriode() {
		return periode;
	}

	public void setPeriode(int periode) {
		this.periode = periode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
	
	
	
	
}
