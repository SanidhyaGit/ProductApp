package com.incapp.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DAO {
	private Connection c;
	
	public DAO() throws SQLException,ClassNotFoundException  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/productapp", "root", "Incapp@12");
	}
	
	public void closeConnection()throws SQLException {
		c.close();
	}
	
	public String adminLogin(String id, String password) throws SQLException{
		PreparedStatement p=c.prepareStatement("select * from login where id = ? and password = ?");
		p.setString(1, id);
		p.setString(2, password);
		ResultSet rs=p.executeQuery();
		if(rs.next()) {
			return rs.getString("name");
		}else {
			return null;
		}
	}
	
	public String addProduct(HashMap product) throws SQLException{
		try {
			PreparedStatement p=c.prepareStatement("insert into users (companyname,name,price,description) values (?,?,?,?)");
			p.setString(1, (String)product.get("companyname"));
			p.setString(2, (String)product.get("name"));
			p.setInt(3, (Integer)product.get("price"));
			p.setString(4, (String)product.get("description"));
			p.executeUpdate();
			return "Product Added Successfully !";
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			return "Product Already Exist";
		}
	}
	
	public ArrayList<HashMap> getUsersLikeName(String n) throws SQLException{
		PreparedStatement p=c.prepareStatement("select * from users where name like ?");
		p.setString(1, "%"+n+"%");
		ResultSet rs=p.executeQuery();
		ArrayList<HashMap> users=new ArrayList<>(); 
		while(rs.next()) {
			HashMap<String, Object> product=new HashMap();
			product.put("companyname", rs.getString("companyname"));
			product.put("name", rs.getString("name"));
			product.put("price", rs.getInt("price"));
			product.put("description", rs.getString("description"));
			
			users.add(product);
		}
		return users;}}
