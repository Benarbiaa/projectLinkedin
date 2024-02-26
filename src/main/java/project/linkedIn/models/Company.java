package project.linkedIn.models;

import java.util.Map;
import java.util.Set;

public class Company {
	private Map<User,String> employees;
	private String domaine;
	private String description;
	private Set<String> technologies ;
	public Company(Map<User, String> employees, String domaine, String description, Set<String> technologies) {
		super();
		this.employees = employees;
		this.domaine = domaine;
		this.description = description;
		this.technologies = technologies;
	}
	public Map<User, String> getEmployees() {
		return employees;
	}
	public void setEmployees(Map<User, String> employees) {
		this.employees = employees;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<String> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(Set<String> technologies) {
		this.technologies = technologies;
	}
	
	
}
