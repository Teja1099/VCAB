package com.teja.dao;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class DriverReg {
	public boolean push(String uid,String email,String mbno,String pass,String address) throws SQLException {
		System.out.println("suc");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/vcab","root","1234");
			PreparedStatement sql;
			try {
				sql = con.prepareStatement("insert into driverStatus values(?,?,?,?)");
				sql.setString(1, email);
				sql.setDouble(2, 14.22);
				sql.setDouble(3,14.22);
				sql.setString(4, "free");
				sql.execute();
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			try {
				sql = con.prepareStatement("insert into drivers values(?,?,?,?,?)");
				sql.setString(1, uid);
				sql.setString(2, email);
				sql.setString(3, mbno);
				sql.setString(4, pass);
				sql.setString(5, address);
				sql.execute();
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			
			try {
				sql = con.prepareStatement("insert into users values(?,?,?,?,?)");
				sql.setString(1, uid);
				sql.setString(2, email);
				sql.setString(3, mbno);
				sql.setString(4, pass);
				sql.setString(5, "driver");
				sql.execute();
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
}
