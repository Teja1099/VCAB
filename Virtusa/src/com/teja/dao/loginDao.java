package com.teja.dao;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class loginDao {
	
	public String check(String name,String pass) {
		 String roleDB = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/vcab","root","1234");
			PreparedStatement st=  con.prepareStatement("select role from users where email=? and password=?");
			st.setString(1, name);
			st.setString(2, pass);
			ResultSet rs= st.executeQuery();
/*			if(rs.next())  {
				return roleDB;
			}*/
			  while(rs.next())
			  {
			   roleDB = rs.getString("role");

			   if( roleDB.equals("Admin"))
			   return "Admin_Role";
			   else if(roleDB.equals("driver"))
			   return "Driver_Role";
			   else if(roleDB.equals("User"))
			   return "User_Role";
			  }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
