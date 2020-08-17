package com.teja.dao;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class driverLocDao {
	public boolean push(String email,double lat,double lng) throws SQLException {
		System.out.println("suc");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/vcab","root","1234");
			PreparedStatement sql;
			try {
				sql = con.prepareStatement("update driverStatus set lat=? , longi=? where email=? ");
				sql.setDouble(1, lat);
				sql.setDouble(2, lng);
				sql.setString(3, email);
				sql.executeUpdate();
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
