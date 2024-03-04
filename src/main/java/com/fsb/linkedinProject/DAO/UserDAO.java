package com.fsb.linkedinProject.DAO;
import java.time.LocalDate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.fsb.linkedinProject.Models.*;
import com.fsb.linkedinProject.utils.ConxDB;
import java.time.LocalDate;

public class UserDAO {
	private static Connection conn = ConxDB.getInstance();
	
	public static List<String> getEmails(){
		Statement stmt = null;
		ResultSet rs = null;
		
		List<String> emails = new ArrayList<>();
		
		String SQL = "SELECT address FROM account";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			while(rs.next()) {
				String email = rs.getString(1);
				emails.add(email);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return emails;
		
	}
	
	
	public static int addAccount(Account acc) {
		int id=0;
		ResultSet rs = null;
		User user = acc.getUser();
		try {
			String sql1 = "INSERT INTO account (address,password) VALUES(?,?)";
			PreparedStatement pstatement = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			pstatement.setString(1, acc.getAddress());
			pstatement.setString(2, acc.getPassword());
			pstatement.executeUpdate();
			rs = pstatement.getGeneratedKeys();
			rs = pstatement.getGeneratedKeys();
			if (rs.next()) id = rs.getInt(1);
			if(id!=0){
				String sql = "INSERT INTO user (id_user,name,birthday,role,phone_number,address_physique,photo,state) VALUES(?,?,?,?,?,?,?,?) ";
				pstatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				pstatement.setInt(1, id);
				pstatement.setString(2, user.getName());
				pstatement.setObject(3, user.getBirthday());
				pstatement.setString(4, user.getRole());
				pstatement.setInt(5, user.getPhoneNumber());
				pstatement.setString(6, user.getAddressPhysique());
				pstatement.setBinaryStream(7, user.getPhoto());
				pstatement.setString(8, "actif");
				pstatement.executeUpdate();
				if (user instanceof Employee) {
					UserDAO.addEmployee((Employee) user, id);

				}
				else{
					UserDAO.addCompany((Company) user, id);
				}
			}


		}

			catch(SQLException ex){
				System.out.println("SQL Exception:");
				ex.printStackTrace();
			}

		return id;}
	
	public static boolean addEmployee(Employee employee,int id) {
		System.out.println(conn);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO employee (id_user,last_name,gender) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.setString(2,employee.getLastName());
			pstmt.setString(3, employee.getGender());
			pstmt.executeUpdate();
			if (employee.getCompetences()!=null) {
				for (Competence c : employee.getCompetences()) {
					addCompetence(id, c);
				}
			}
			if (employee.getExperiences()!=null) {
				for (Experience e : employee.getExperiences()) {
					addExperience(id, e);
				}
			}
			System.out.println("success");
			return true;
			
		}catch(SQLException ex) {
			System.out.println("SQL Exception:");
		    ex.printStackTrace();
			return false;
		}

	}
	public static boolean addCompany(Company company,int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO company (id_company,domaine,description) VALUES(?,?,?) ";
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, id);
			pstmt.setString(2,company.getDomaine());
			pstmt.setObject(3,company.getDescription());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) rs.getInt(1);
			return true;
		}catch(SQLException ex) {
			System.out.println("SQL Exception:");
		    ex.printStackTrace();
			return false;
		}

	}

	public static void addCompetence(int id,Competence competence){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO competences (id_competence,title,technology,description,level,id_employee) VALUES(?,?,?,?,?,?) ";
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1,competence.getIdCompetence());
			pstmt.setString(2,competence.getTitle());
			pstmt.setString(3,competence.getTechnology());
			pstmt.setString(4,competence.getDescription());
			pstmt.setString(5,competence.getDescription());
			pstmt.setInt(6, id);
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) rs.getInt(1);
		}catch(SQLException ex) {
			System.out.println("SQL Exception:");
			ex.printStackTrace();
		}
	}
	public static void addExperience(int id,Experience experience){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO experiences (id_experience,periode,description,post,technology,id_employee) VALUES(?,?,?,?,?,?) ";
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1,experience.getIdExperience());
			pstmt.setInt(2,experience.getPeriode());
			pstmt.setString(3,experience.getDescription());
			pstmt.setString(4,experience.getPoste());
			pstmt.setString(5,experience.getTechnology());
			pstmt.setInt(6, id);
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) rs.getInt(1);
		}catch(SQLException ex) {
			System.out.println("SQL Exception:");
			ex.printStackTrace();
		}
	}

	public static List<Competence> getCompetences(int id){
		List<Competence> cmps = new ArrayList<>();

		Statement stmt = null;
		ResultSet rs = null;

		String SQL = "SELECT * FROM competences WHERE id_employee=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1,id);
			try{
				rs = ps.executeQuery();
				while(rs.next()) {
					Competence c =new Competence(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5)
					);
					cmps.add(c);

				}
			} catch (SQLException e) {
				e.printStackTrace();
            }
        }catch(SQLException e) {
			e.printStackTrace();
		}
		return cmps;

	}
	public static List<Experience> getExperiences(int id){
		List<Experience> exps = new ArrayList<>();

		Statement stmt = null;
		ResultSet rs = null;

		String SQL = "SELECT * FROM experiences WHERE id_employee=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1,id);
			try{
				rs = ps.executeQuery();
				while(rs.next()) {
					Experience e =new Experience(
							rs.getInt(1),
							rs.getInt(3),
							rs.getString(2),
							rs.getString(4),
							rs.getString(5)
					);
					exps.add(e);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return exps;

	}



}
