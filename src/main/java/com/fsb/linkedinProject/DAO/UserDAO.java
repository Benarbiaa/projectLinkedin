package com.fsb.linkedinProject.DAO;

import com.fsb.linkedinProject.Models.*;
import com.fsb.linkedinProject.utils.ConxDB;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

public class UserDAO {
	private static final Connection conn = ConxDB.getInstance();

	public static Account getAccount(String address) throws SQLException, IOException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * from account WHERE address = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1,address);
		rs = ps.executeQuery();
		if(rs.next()){
			String email = rs.getString(1);
			String password = rs.getString(2);
			int id = rs.getInt(3);
            return new Account(email,password,UserDAO.getUser(id));
		}
		return null;

	}


	public static List<String> getEmails(){
		Statement stmt;
		ResultSet rs;
		
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
			for (String tech : company.getTechnologies()){
				UserDAO.addTechnology(tech , id);
			}
			return true;
		}catch(SQLException ex) {
		    ex.printStackTrace();
			return false;
		}

	}

	public static int addTechnology(String tech , int id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "INSERT INTO technology(title,id_company) VALUES(?,?)";
		ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1,tech);
		ps.setInt(2,id);
		ps.executeUpdate();
		rs=ps.getGeneratedKeys();
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
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

	public static Set<String> getTechnologies(int idCompany) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<String> technologies = new HashSet<>();

		String sql = "SELECT title from technology WHERE id_company = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1,idCompany);
		rs = ps.executeQuery();
		while (rs.next()){
			technologies.add(rs.getString(1));
		}
		return technologies;
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


	public static User getUser(int id) throws SQLException, IOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM user WHERE id_user=?";

		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		String sql1;

		ps = conn.prepareStatement(SQL);
		ps.setInt(1,id);
		rs = ps.executeQuery();
		if (rs.next()){
			String name = rs.getString(2);
			LocalDate birthday =rs.getDate(3).toLocalDate();
			String role = rs.getString(4);
			int phoneNumber = rs.getInt(5);
			String addressPhysique = rs.getString(6);
			FileInputStream photo = null;
			Blob blob = rs.getBlob(7);
			if (blob!=null) {
				byte[] bytes = blob.getBytes(1, (int) blob.length());
				ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				File tempFile = File.createTempFile("photo_", ".tmp");

				// Write bytes to the temporary file
				try (FileOutputStream fos = new FileOutputStream(tempFile)) {
					fos.write(bytes);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				photo = new FileInputStream(tempFile);

				tempFile.delete();
			}
			String state = rs.getString(8);
			if(role.compareTo("employee")==0){
				sql1 = "SELECT * FROM employee WHERE id_user = ?";
				ps1 = conn.prepareStatement(sql1);
				ps1.setInt(1,id);
				rs1 = ps1.executeQuery();
				int company = 0;
				if (rs1.next()){
					String lastName = rs1.getString(2);
					String gender = rs1.getString(3);
					if(rs1.getObject(4)!=null){
						company = rs1.getInt(4);
					}
					List<Experience> el = UserDAO.getExperiences(id);
					List<Competence> cl = UserDAO.getCompetences(id);
					User user = new Employee(id,name,birthday,role,phoneNumber,addressPhysique,photo,state,lastName,el,cl,gender,null,(Company)UserDAO.getUser(company));
					return user;
				}

            }
			else{
				sql1 = "SELECT * FROM company WHERE id_company = ?";
				ps1 = conn.prepareStatement(sql1);
				ps1.setInt(1,id);
				rs1 = ps1.executeQuery();
				if (rs1.next()){
					String domaine = rs1.getString(2);
					String description = rs1.getString(3);
					User user = new Company(id,name,birthday,role,phoneNumber,addressPhysique,photo,state,null,domaine,description,UserDAO.getTechnologies(id));
					return user;
				}
            }
        }
		return null;
	}

	public static void addRelation(User user1 , User user2) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println(user1.getIdUser());
		System.out.println(user2.getIdUser());
		String sql = "INSERT INTO relations (id_first_user,id_second_user) VALUES (?,?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(1,user1.getIdUser());
		ps.setInt(2,user2.getIdUser());
		ps.executeUpdate();
	}

}
